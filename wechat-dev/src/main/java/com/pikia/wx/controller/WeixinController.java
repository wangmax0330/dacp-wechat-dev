package com.pikia.wx.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pikia.component.web.util.EncoderHandler;
import com.pikia.component.web.util.ResponseUtils;
import com.pikia.wx.service.WeixinService;
import com.pikia.wx.util.WeixinUtil;

/**
 * 微信处理消息
 * 
 * @author methew
 * 
 */
@Controller
public class WeixinController {
	@Resource
	private WeixinService weixinService;

	@RequestMapping(value = "/wechat/wx", method = { RequestMethod.GET })
	public void join(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			String token = WeixinUtil.token;
			if (StringUtils.isNotBlank(signature)) {
				List<String> ls = new ArrayList();
				ls.add(timestamp);
				ls.add(nonce);
				ls.add(token);
				Collections.sort(ls);
				String tmp = "";
				for (String str : ls) {
					tmp += str;
				}
				String en = EncoderHandler.encode("SHA1", tmp);
				if (en.equals(signature))
					ResponseUtils.writeMessage(response, echostr);
			}
		} catch (Exception ex) {
			//logger.error("Error occurred in method login", ex);
		}
	}

	/***
	 * 留给开发人员覆写
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/wechat/wx", method = { RequestMethod.POST })
	public void msg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String signature = request.getParameter("signature");
		// String timestamp = request.getParameter("timestamp");
		// String nonce = request.getParameter("nonce");
		// String echostr = request.getParameter("echostr");
		//
		// String token = "sdlc_wechat_token";
		// List<String> ls = new ArrayList();
		// ls.add(timestamp);
		// ls.add(nonce);
		// ls.add(token);
		// Collections.sort(ls);
		// String signtmp = "";
		// for (String str : ls) {
		// signtmp += str;
		// }
		// String en = EncoderHandler.encode("SHA1", signtmp);
		// TextMessage text = new TextMessage();
		// NewsMessage news = new NewsMessage();
		// int flag = 0;
		//
		// if (en.equals(signature)) {
		// Map<String, String> xml = MessageUtil.parseXml(request);
		// // Iterator<String> it = xml.keySet().iterator();
		// // while (it.hasNext()) {
		// // String key = it.next();
		// // logger.error(key + "--->" + xml.get(key));
		// // }
		// String toUserName = xml.get("ToUserName");
		// String openId = xml.get("FromUserName");
		// String content = xml.get("Content"); // 获取用户乎回复内容
		// String msgType = xml.get("MsgType");
		//
		// text.setCreateTime(System.currentTimeMillis());
		// text.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		// text.setToUserName(openId);
		// text.setFromUserName(toUserName);
		//
		// news.setCreateTime(System.currentTimeMillis());
		// news.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		// news.setToUserName(openId);
		// news.setFromUserName(toUserName);
		// news.setFuncFlag(0);
		// try {
		// if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
		//
		// }
		// if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
		//
		// }
		// if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
		// String eventType = xml.get("Event");
		// if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
		//
		// } else if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
		// boolean needLog = false;
		// String realIp = RequestUtils.getIpAddr(request);
		// // 首次订阅,如果该微信用户没有和app绑定,则创建用户
		// ApsUserDomain user = null;
		// user = this.apsUserService.validateByWechatAccount(openId);
		// List<Article> articles = new ArrayList<Article>();
		// if (user == null) {
		// // 调用通用接口注册新用户
		// user = new ApsUserDomain();
		// user.setCreateTime(new Date());
		// user.setWechatAccount(openId);
		// Random rand = new Random();
		// String code = String.valueOf(Math.abs(rand.nextInt()) % (9999999 -
		// 1000000 + 1) + 1000000);
		// user.setUserName(code);
		// needLog = true;
		// //this.apsUserService.saveOrUpdate(user);
		//
		// String eventKey = xml.get("EventKey");
		// String ticket = xml.get("Ticket");
		// logger.error("****************" + ticket);
		// logger.error("****************" + eventKey);
		//
		// // 扫二维码的关注
		// if (StringUtils.isNotBlank(eventKey) ||
		// StringUtils.isNotBlank(ticket)) {
		// Article article0 = new Article();
		// article0.setTitle("扫二维码关注");
		// article0.setPicUrl(WeixinUtil.serverUrl +
		// "/res/images/wechat/hongcha.png");
		// article0.setDescription("1111");
		// article0.setUrl(WeixinUtil.serverUrl + "?openId=" + openId +
		// "&prizeDealId=" + 11);
		// articles.add(article0);
		// }
		// }
		// Article article1 = new Article();
		// article1.setTitle("谢谢关注");
		// article1.setPicUrl(WeixinUtil.serverUrl +
		// "/res/images/wechat/intro.png");
		// article1.setDescription("就是这股feel,倍爽");
		// article1.setUrl(WeixinUtil.serverUrl + "?openId=" + openId);
		// articles.add(article1);
		//
		// Article article2 = new Article();
		// article2.setTitle("详细请看");
		// article2.setPicUrl(WeixinUtil.serverUrl +
		// "/res/images/wechat/pic1.png");
		// article2.setDescription("最实用的,最贵的,最好的");
		// article2.setUrl(WeixinUtil.serverUrl + "?openId=" + openId);
		// articles.add(article2);
		//
		// Article article3 = new Article();
		// article3.setTitle("我要抽奖换大礼");
		// article3.setPicUrl(WeixinUtil.serverUrl +
		// "/res/images/wechat/lottery.png");
		// article3.setDescription("缤纷好礼,缤纷色彩");
		// article3.setUrl(WeixinUtil.serverUrl + "?openId=" + openId);
		// articles.add(article3);
		//
		// news.setArticleCount(articles.size());
		// news.setArticles(articles);
		// ResponseUtils.writeMessage(response,
		// MessageUtil.newsMessageToXml(news));
		// return;
		// } else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
		// String eventKey = xml.get("EventKey");
		// if ("jd_sao_cp_js".equals(eventKey)) {
		// // 玩转集豆扫
		// List<Article> articles = new ArrayList<Article>();
		// Article article = new Article();
		// article.setTitle("欢迎使用微信助手");
		// article.setPicUrl(WeixinUtil.serverUrl +
		// "/res/images/wechat/intro.png");
		// article.setDescription("感谢你使用微信助手,我们将竭诚为你服务!");
		// article.setUrl(WeixinUtil.serverUrl + "/web/weixin/introduce");
		// articles.add(article);
		// news.setArticleCount(articles.size());
		// news.setArticles(articles);
		// ResponseUtils.writeMessage(response,
		// MessageUtil.newsMessageToXml(news));
		// return;
		// } else if ("jd_sao_rm_hd".equals(eventKey)) {
		// } else if ("jd_sao_kf_rx".equals(eventKey)) {
		// // 客服热线\n1
		// text.setContent("客服热线:\n");
		// } else if ("jd_sao_zx_zx".equals(eventKey)) {
		//
		// }
		// } else if
		// (eventType.equals(MessageUtil.EVENT_TYPE_PIC_PHOTO_OR_ALBUM)) {
		//
		// } else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION_SELECT))
		// {
		//
		// text.setContent("欢迎你");
		// } else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
		// // 扫描二维码事件处理
		// } else {
		// text.setContent("欢迎你");
		// }
		// } else {
		// text.setContent("欢迎你");
		//
		// }
		//
		// } catch (Exception ex) {
		// logger.error(ex, ex);
		// text.setContent("欢迎你,出错了!!!");
		// }
		// ResponseUtils.writeMessage(response,
		// MessageUtil.textMessageToXml(text));
		// }
	}

}
