package com.pikia.wx.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pikia.component.property.SystemProperties;
import com.pikia.component.web.util.DateUtils;
import com.pikia.component.web.util.JsonUtils;
import com.pikia.wx.domain.AccessToken;
import com.pikia.wx.domain.Menu;
import com.pikia.wx.domain.MyX509TrustManager;
import com.pikia.wx.domain.Template;
import com.pikia.wx.domain.TemplateMessage;

/**
 * 公众平台通用接口工具类
 * 
 * @author liuyq
 * @date 2013-08-09
 */
public class WeixinUtil {
	private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

	public static String appid;
	public static String appsecret;
	public static String serverUrl;
	public static String token;

	static {
		appid = SystemProperties.getProperties("appid");
		appsecret = SystemProperties.getProperties("appsecret");
		serverUrl = SystemProperties.getProperties("serverUrl");
		token = SystemProperties.getProperties("token");
	}

	/**
	 * 删除菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int deleteMenu(String accessToken) {
		int result = 0;
		String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", null);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("删除菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		System.out.println(result);
		return result;
	}

	// /**
	// * 创建菜单
	// *
	// * @param menu
	// * 菜单实例
	// * @param accessToken
	// * 有效的access_token
	// * @return 0表示成功，其他值表示失败
	// */
	// public static int createMenu(String accessToken) {
	// int result = 0;
	// String menu_create_url =
	// " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// // 拼装创建菜单的url
	// String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
	// // 将菜单对象转换成json字符串
	// String jsonMenu = JsonUtils.JSON_Bean2String(getMenu());
	// // 调用接口创建菜单
	// JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
	//
	// if (null != jsonObject) {
	// if (0 != jsonObject.getInt("errcode")) {
	// result = jsonObject.getInt("errcode");
	// log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
	// jsonObject.getString("errmsg"));
	// }
	// }
	// System.out.println(result);
	// return result;
	// }

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(String accessToken, Menu menu) {
		int result = 0;
		String menu_create_url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JsonUtils.JSON_Bean2String(menu);
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		System.out.println(result);
		return result;
	}

	// public static Menu getMenu() {
	// Menu menu = new Menu();
	// Button[] btn = new Button[3]; // 主按钮
	//
	// // CommonButton cbtn32 = new CommonButton();
	// // cbtn32.setName("首页");
	// // cbtn32.setType("click");
	// // cbtn32.setKey("jd_sao_zx_zx");
	// // btn[0] = cbtn32;
	// ViewButton cbtn32 = new ViewButton();
	// cbtn32.setName("爆款预售");
	// cbtn32.setType("view");
	// cbtn32.setUrl("http://www.octlr.com/wechat/d/page/hot_product");
	// btn[0] = cbtn32;
	//
	// // CommonButton cbtn22 = new CommonButton();
	// // cbtn22.setName("预约装修");
	// // cbtn22.setType("pic_photo_or_album");
	// // cbtn22.setKey("rselfmenu_1_1");
	//
	// ViewButton cbtn22 = new ViewButton();
	// cbtn22.setName("工长加盟");
	// cbtn22.setType("view");
	// cbtn22.setUrl("http://www.octlr.com/wechat/d/page/chargehand_join");
	// btn[1] = cbtn22;
	//
	// ViewButton cbtn11 = new ViewButton();
	// cbtn11.setName("我要装修");
	// cbtn11.setType("view");
	// cbtn11.setUrl("http://www.octlr.com/wechat/d/page/index");
	//
	// btn[2] = cbtn11;
	//
	// menu.setButton(btn);
	// return menu;
	// }

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken() {

		// 获取access_token的接口地址（GET） 限200（次/天）
		final String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
				// System.out.println(accessToken.getToken());
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**
	 * 下载保存多媒体文件,返回多媒体byte[]
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param mediaId
	 *            文件在服务器上的存储路径
	 * @return
	 */
	public static final String download_media_url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

	/**
	 * 从微信服务器下载多媒体文件,返回byte数组
	 * 
	 * @param accessToken
	 * @param mediaId
	 * @return
	 * @throws IOException
	 */
	public static byte[] downloadMediaFromWx(String accessToken, String mediaId) {

		if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(mediaId))
			return null;
		String requestUrl = download_media_url.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		URL url;
		try {
			url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			InputStream in = conn.getInputStream();

			String ContentDisposition = conn.getHeaderField("Content-disposition");
			// 图片在微信服务器上的名称
			String weixinServerFileName = ContentDisposition.substring(ContentDisposition.indexOf("filename") + 10, ContentDisposition.length() - 1);
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[100];
			int rc = 0;
			while ((rc = in.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
			in.close();
			byte[] inbytes = swapStream.toByteArray();
			conn.disconnect();
			return inbytes;
		} catch (Exception e) {
			log.error("weixin  download  picture source error !  ", e);
		}
		return null;
	}

	/**
	 * 通过oauth2 验证获取用户openId
	 * 
	 * @param code
	 * @return
	 */
	public static String getOpenId(String code) {
		try {
			String accesstokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + appsecret + "&code=" + code
					+ "&grant_type=authorization_code";
			JSONObject jsonObject = httpRequest(accesstokenUrl, "POST", null);
			// String refreshToken=jsonObject.getString("refresh_token");
			String openID = jsonObject.getString("openid");
			if (StringUtils.isNotBlank(openID)) {
				return openID;
			}
		} catch (Exception e) {
			log.error("wechat browser auth to get user openid error	!", e);
		}
		return null;
	}

	/**
	 * 获取jsapi_ticket 的地址; jsapi_ticket是公众号用于调用微信JS接口的临时票据jsapi_ticket的有效期为7200秒
	 */
	private static String jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	/**
	 * 获取jsapi_ticket,jsapi_ticket是公众号用于调用微信JS接口的临时票据jsapi_ticket的有效期为7200秒
	 * 
	 * @param accessToken
	 * @return
	 */
	public static String getJsapi_ticket(String accessToken) {
		try {
			if (StringUtils.isEmpty(accessToken))
				return null;
			String requestUrl = jsapi_ticket_url.replace("ACCESS_TOKEN", accessToken);
			JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
			String ticket = jsonObject.getString("ticket");
			if (StringUtils.isNotBlank(ticket)) {
				return ticket;
			}
		} catch (Exception e) {
			log.error("wechat browser to get jsapi_ticket error!", e);
		}
		return null;
	}

	/**
	 * 
	 * @param nonceStr
	 *            参与签名的字段(随机字符串)
	 * @param timestamp
	 *            时间戳(10位)
	 * @param url
	 *            当前页面所在域名，不包含#及其后面部分
	 * @param jsapi_ticket
	 * @return
	 */
	public static String getSignature(String nonceStr, String timestamp, String url, String jsapi_ticket) {
		// 步骤一:对所有待签名参数按照字段名的ASCII
		// 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1：
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
		// 步骤二:对string1进行sha1签名，得到signature：
		String signature = encryptPassword(str);
		return signature;
	}

	/**
	 * sha1加密
	 * 
	 * @param password
	 * @return
	 */
	public static String encryptPassword(String password) {
		String sha1 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			// 为计算一些数值的摘要，应当向已初始化的消息摘要对象提供数据
			crypt.update(password.getBytes("UTF-8"));
			sha1 = byteToHex(crypt.digest());
		} catch (Exception e) {

		}
		return sha1;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);// %02X：以十六进制输出,2为指定的输出字段的宽度.如果位数小于2,则左端补0
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * 获取用户一些基本信息,包括昵称(nickname),性别(sex),城市(city),省份(province) 头像地址(headimgurl),注册时间 (subscribe_time),UnionID(同一用户，对同一个微信开放平台帐号下的不同应用，UnionID是相同的)
	 * 
	 * @param openID
	 * @param accessToken
	 * @return
	 */
	public static JSONObject getUserBasicInformation(String openID, String accessToken) {
		// {"subscribe":1,"openid":"","nickname":"","sex":1,"language":"en","city":"无锡","province":"江苏","country":"中国","headimgurl":"","subscribe_time":1423232385,"remark":""}
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		requestUrl = requestUrl.replace("OPENID", openID);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		if (jsonObject.has("errcode"))
			return null;
		else
			return jsonObject;
	}

	/**
	 * 发送模板消息,优惠券到账通知
	 * 
	 * @param touser
	 * @param originalUrl
	 *            用户点击消息,跳转的url
	 * @param accessToken
	 * @param prizeName
	 * @return
	 */
	public static boolean sendTempletMessage0(String touser, String originalUrl, String accessToken, String prizeName) {
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		Map<String, Template> data = new HashMap<String, Template>();
		String template_id = null;
		template_id = "m5nuD-kw6RuHTOvTKeKci22vWHtoXnS3fPqa7_YTbMQ"; // 优惠券到账通知
		Template first = new Template(), keynote1 = new Template(), keynote2 = new Template(), remark = new Template();
		first.setColor("#173177");
		first.setValue("您的好友使用了您分享的礼包,恭喜您同时获得【 " + prizeName + " 】");
		keynote1.setColor("#173177");
		keynote1.setValue("闪购商城");
		keynote2.setColor("#173177");
		keynote2.setValue("抵换豆币获取实物奖品");
		remark.setColor("#173177");
		remark.setValue("\n推荐更多好友,可以获取更多优惠卷哦");

		data.put("remark", remark);
		data.put("orderTicketRule", keynote2);
		data.put("orderTicketStore", keynote1);
		data.put("first", first);
		TemplateMessage templateMessage = new TemplateMessage();
		templateMessage.data(data).topColor("#FF0000").url(originalUrl).template_id(template_id).touser(touser);
		JSONObject result = httpRequest(requestUrl, "POST", JSONObject.fromObject(templateMessage).toString());
		if ((Integer) result.get("errcode") == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 发送模板消息,装修进度
	 * 
	 * @param touser
	 * @param originalUrl
	 *            用户点击消息,跳转的url
	 * @param accessToken
	 * @param prizeName
	 * @return
	 */
	public static boolean sendDecoratorProgessMessage(String touser, String originalUrl, String accessToken, String projectId, String timestamp,
			String sectionType) {
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		Map<String, Template> data = new HashMap<String, Template>();
		String template_id = null;
		template_id = "747uQiO8mOsA4963TAZ2ebjlGHx_-xtSE1W3R-6K86U";
		Template first = new Template(), keynote1 = new Template(), keynote2 = new Template(), keynote3 = new Template(), remark = new Template();
		first.setColor("#173177");
		first.setValue("尊敬的客户您好，您的装修进度如下");
		keynote1.setColor("#173177");
		keynote1.setValue(projectId + "");
		keynote2.setColor("#173177");
		keynote2.setValue(sectionType);
		keynote3.setColor("#173177");
		keynote3.setValue(timestamp);
		remark.setColor("#173177");
		remark.setValue("\n推荐更多好友,可以获取优惠");
		data.put("remark", remark);
		data.put("keyword1", keynote1);
		data.put("keyword2", keynote2);
		data.put("keyword3", keynote3);
		data.put("first", first);
		TemplateMessage templateMessage = new TemplateMessage();
		templateMessage.data(data).topColor("#FF0000").url(originalUrl).template_id(template_id).touser(touser);
		JSONObject result = httpRequest(requestUrl, "POST", JSONObject.fromObject(templateMessage).toString());
		if ((Integer) result.get("errcode") == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 活取二维码ticket
	 * 
	 * @param accessToken
	 */
	public static JSONObject getQRCodeTicket(String accessToken, Long targetId) {
		String qrCodeTicketUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
		qrCodeTicketUrl = qrCodeTicketUrl.replace("TOKEN", accessToken);
		// 临时二维码请求说明
		// POST数据例子：{"expire_seconds": 1800, "action_name": "QR_SCENE",
		// "action_info": {"scene": {"scene_id": 123}}}
		// 永久二维码请求说明
		// POST数据例子：{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene":
		// {"scene_id": 123}}}
		String tempQRCodeJson = "{\"expire_seconds\": 1800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": " + targetId
				+ "}}}";
		String permanenQRCodeJson = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": " + targetId + "}}}";
		// 返回Json格式{"ticket":"gQH47joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2taZ2Z3TVRtNzJXV1Brb3ZhYmJJAAIEZ23sUwMEmm3sUw==","expire_seconds":60,"url":"http:\/\/weixin.qq.com\/q\/kZgfwMTm72WWPkovabbI"}
		JSONObject resultJson = httpRequest(qrCodeTicketUrl, "GET", permanenQRCodeJson);
		return resultJson;
	}

	public static String getQRCodeUrl(String accessToken, Long targetId) {
		JSONObject resultJson = getQRCodeTicket(accessToken, targetId);
		String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + resultJson.getString("ticket");
		return url;
	}

	public static void main(String[] args) {
		// ---------------------------------推送消息的demo
		// AppCouponTaskDetailVo taskDetailVo=new AppCouponTaskDetailVo();
		// taskDetailVo.setTips(1);
		// ApsUserDomain userDomain=new ApsUserDomain();
		// userDomain.setAmount(134d);
		// userDomain.setWeixinAccount("oKzr_tp6Bb1B-IuqkmHIWI2cjYXY");
		// WeixinUtil.sendTempletMessage1(null,taskDetailVo,userDomain,
		// WeixinUtil.myAccountMenuUrl,WeixinUtil.getAccessToken().getToken());
		// WeixinUtil.sendTempletMessage0("oKzr_tp6Bb1B-IuqkmHIWI2cjYXY",WeixinUtil.myAccountMenuUrl,WeixinUtil.getAccessToken().getToken(),
		// "5元豆券");
		// ---------------------------------活取自定义参数的二维码demo
		// AccessToken accessToken = getAccessToken();
		// System.out.println(accessToken.getToken());
		// JSONObject jsonObject = getQRCodeTicket(accessToken.getToken(),
		// 01111l);
		// System.out.println(getQRCodeUrl(accessToken.getToken(), 1111l));
		WeixinUtil.sendDecoratorProgessMessage("oGE8gwJM-v3SSBVfDzvIe8W3KFiQ", "", WeixinUtil.getAccessToken().getToken(), "1111111",
				DateUtils.date2Str(new Date()), "水电改造");
		// WeixinUtil.appid = "wx72154d0c46dda56c";
		// WeixinUtil.appsecret = "8ae39c7b0200d16fa80bbf6fe7932522";
		// WeixinUtil.serverUrl = "http://www.octlr.com";
		// WeixinUtil.token = "sdlc_wechat_token";
		//
		// JSONObject jsonObject =
		// WeixinUtil.getUserBasicInformation("oGE8gwJM-v3SSBVfDzvIe8W3KFiQ",
		// getAccessToken()
		// .getToken());
		// System.out.println(jsonObject);
		// System.out.println((byte) jsonObject.getInt("sex"));
		// System.out.println(jsonObject.getString("nickname"));
		// System.out.println(jsonObject.getString("headimgurl"));

		byte[] bytes = WeixinUtil.downloadMediaFromWx(getAccessToken().getToken(),
				"-dfFL6e5gkS4HUIScVYlqeFOx93zJX0VMGKfTE0y37pXAreR8JR1ESqKDFvPghZJFrigOTi1MIrk3igB4oxj8ZQwkmoxhfWfoxL3Ki64ZAiKcN-5L3D9PMMG6cTNNe9QN");
		System.out.println(bytes);
		System.out.println("11");

	}
}