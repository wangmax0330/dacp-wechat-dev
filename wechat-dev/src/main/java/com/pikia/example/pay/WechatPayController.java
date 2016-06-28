package com.pikia.example.pay;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pikia.component.web.util.DateUtils;
import com.pikia.component.web.util.RequestUtils;
import com.pikia.wx.service.WeixinService;
import com.pikia.wx.util.CommonUtil;
import com.pikia.wx.util.ConfigUtil;
import com.pikia.wx.util.PayCommonUtil;
import com.pikia.wx.util.WechatSign;
import com.pikia.wx.util.WeixinUtil;

@Controller
@RequestMapping("/wechatpay")
public class WechatPayController {

	private static final Logger logger = Logger.getLogger(WechatPayController.class);
	@Resource
	private WeixinService weixinService;

	/**
	 * 查询cookie 中是否保留有用户openId,没有就跳转到oauth 验证
	 */
	public String getOpenId(HttpServletRequest request) {
		try {
			Cookie[] cookies = request.getCookies();
			String openId = null;
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("sdlc_openId_")) {
						openId = cookie.getValue();
						if (StringUtils.isNotBlank(openId)) {
							openId = URLDecoder.decode(openId);
						}
					}
				}
			}
			return openId;
		} catch (Exception e) {
			logger.error(e, e);
			return null;
		}

	}

	@SuppressWarnings("unused")
	@RequestMapping("/jspay")
	public String jspay(HttpServletRequest request, HttpServletResponse response) {
		String openId = request.getParameter("openId");
		if (StringUtils.isBlank(openId)) {
			openId = getOpenId(request);
		}
		// String projectId = request.getParameter("projectId");
		// String projectSection = request.getParameter("projectSection");
		// request.setAttribute("projectId", projectId);
		// Project project =
		// projectService.getProjectInfoByProjectId(Long.valueOf(projectId));
		// HouseInfo
		// houseInfo=houseService.getHouseInfoByProjectId(Long.valueOf(projectId));
		// request.setAttribute("community_name", houseInfo.getCommunityName());
		// String total_fee = "1";
		// if (StringUtils.isNotBlank(projectSection)) {
		// request.setAttribute("projectSection", projectSection);
		// System.out.println(projectId+"-------project.getTotleFee()------"+project.getTotleFee());
		// total_fee = div(project.getTotleFee(), 5, 2) + "";
		// }else{
		// total_fee=project.getTotleFee()+"";
		// }
		// logger.info("---------total_fee---------" + total_fee);
		// request.setAttribute("total_fee",total_fee);
		// logger.info("---------------支付定金------------" + projectId);
		Map<String, String> signMap = WechatSign.sign(weixinService.checkOutAccessToken().getJsapiTicket(), RequestUtils.requestUrl(request));
		signMap.put("appid", WeixinUtil.appid);
		request.setAttribute("sign", signMap);
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", ConfigUtil.APPID);
		parameters.put("mch_id", ConfigUtil.MCH_ID);
		parameters.put("nonce_str", PayCommonUtil.CreateNoncestr());
		parameters.put("body", "装修款");
		parameters.put("out_trade_no", UUID.randomUUID().toString().replaceAll("-", ""));
		parameters.put("total_fee", "1");
		parameters.put("spbill_create_ip", RequestUtils.getIpAddr(request));
		parameters.put("notify_url", "http://www.octlr.com/wechatpay/callback?projectId=" + 0);
		parameters.put("trade_type", "JSAPI");
		parameters.put("openid", openId);
		String sign = PayCommonUtil.createSign("UTF-8", parameters);
		parameters.put("sign", sign);
		String requestXML = PayCommonUtil.getRequestXml(parameters);
		String result = CommonUtil.httpsRequest(ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);
		logger.info("打印");
		logger.info(requestXML);
		logger.info(result);
		Map<String, String> map = parseXml(result);
		SortedMap<Object, Object> params = new TreeMap<Object, Object>();
		params.put("appId", ConfigUtil.APPID);
		params.put("timeStamp", PayCommonUtil.createTimetmp());
		params.put("nonceStr", PayCommonUtil.CreateNoncestr());
		params.put("package", "prepay_id=" + map.get("prepay_id"));
		params.put("signType", ConfigUtil.SIGN_TYPE);
		String paySign = PayCommonUtil.createSign("UTF-8", params);
		params.put("packageValue", "prepay_id=" + map.get("prepay_id")); // 这里用packageValue是预防package是关键字在js获取值出错
		params.put("paySign", paySign); // paySign的生成规则和Sign的生成规则一致
		String userAgent = request.getHeader("user-agent");
		char agent = userAgent.charAt(userAgent.indexOf("MicroMessenger") + 15);
		params.put("agent", new String(new char[] { agent }));// 微信版本号，用于前面提到的判断用户手机微信的版本是否是5.0以上版本。
		request.setAttribute("jspayMessage", params);
		request.setAttribute("parameters", parameters);
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("out_trade_no", (String) parameters.get("out_trade_no"));
		map2.put("openId", openId);
		return "/wechat/jspay";
	}

	@ResponseBody
	@RequestMapping("/callback")
	public String payCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = parseXml(request);
		if (map.get("result_code").equalsIgnoreCase("SUCCESS")) {
			logger.debug("微信用户支付成功【单据号:" + map.get("out_trade_no") + "】");
			logger.debug("微信用户支付成功  项目编号:   " + 0);
			return PayCommonUtil.setXML("SUCCESS", "");
		}
		return PayCommonUtil.setXML("FAIL", "");
	}

	private static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static Map<String, String> parseXml(HttpServletRequest request) {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 从request中取得输入流
			InputStream inputStream = request.getInputStream();
			// 读取输入流
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			parse(map, document);
			// 释放资源
			inputStream.close();
			inputStream = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, String> parseXml(String request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 读取输入流
			Document document = DocumentHelper.parseText(request);
			parse(map, document);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	private static void parse(Map<String, String> map, Document document) {
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());
	}

}
