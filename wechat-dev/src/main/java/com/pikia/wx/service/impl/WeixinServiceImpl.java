package com.pikia.wx.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pikia.component.cache.CacheHolder;
import com.pikia.component.web.util.DateUtils;
import com.pikia.wx.domain.AccessToken;
import com.pikia.wx.service.WeixinService;
import com.pikia.wx.util.PayCommonUtil;
import com.pikia.wx.util.WeixinUtil;

@Service
public class WeixinServiceImpl implements WeixinService {

	@Resource
	protected CacheHolder cacheHolder;

	protected final Logger logger = Logger.getLogger(WeixinServiceImpl.class);

	@Override
	public AccessToken checkOutAccessToken() {
		AccessToken accessToken = null;
		try {
			accessToken = (AccessToken) cacheHolder.get(AccessToken.class.getName());
			logger.info("获取缓存中的token:         " + accessToken);
			if (accessToken == null) {
				accessToken = WeixinUtil.getAccessToken();
				accessToken.setCreateTime(new Date());
				accessToken.setJsapiTicket(WeixinUtil.getJsapi_ticket(accessToken.getToken()));
			} else {
				Date nowTime = new Date();
				Date cacheTime = accessToken.getCreateTime();
				if ((nowTime.getTime() - cacheTime.getTime()) / (1000 * 60 * 60) > 1) {
					// if ((nowTime.getTime() - cacheTime.getTime()) / (1000) >
					// 60) {
					accessToken = WeixinUtil.getAccessToken();
					accessToken.setCreateTime(new Date());
					accessToken.setJsapiTicket(WeixinUtil.getJsapi_ticket(accessToken.getToken()));
				}
			}
		} catch (Exception e) {
			logger.error("获取新的token失败", e);
		}
		return accessToken;
	}

	@Override
	public void sendDecoratorProgessMessage(String touser, String originalUrl, String projectId, String sectionType) {
		WeixinUtil.sendDecoratorProgessMessage(touser, originalUrl, checkOutAccessToken().getToken(), projectId,
				DateUtils.date2Str(new Date(), DateUtils.DEFAULT_TIMESTAMP_PATTERN), sectionType);
	}

	public Object setWechatProperties_JS_JDK(HttpServletRequest request,
			String shortUrl) {

		AccessToken accessToken = this.checkOutAccessToken();
			String jsapi_ticket = accessToken.getJsapiTicket();
		//	String timestamp = (int) (System.currentTimeMillis() / 1000) + "";
			
			String timeTemp = Long.toString(System.currentTimeMillis());
			String timestamp = timeTemp.substring(0, timeTemp.length() - 3);// 微信接口是要求时间戳是10位
			
			String param=request.getQueryString();
			String url;
			if(StringUtils.isBlank(param)){
				url= request.getRequestURL().toString();
			}else{
				url= request.getRequestURL().toString()+"?"+param;
			}
			logger.info("--------------------------------------------setWechatProperties_JS_JDK:      "+url);
			logger.info("--------------------------------------------setWechatProperties_JS_JD获取的参数:      "+	request.getQueryString());
		
			
			
			String nonceStr = PayCommonUtil.CreateNoncestr();
		//	String url = WeixinUtil.serverUrl + shortUrl;
			String signature = WeixinUtil.getSignature(nonceStr, timestamp, url, jsapi_ticket);
			request.setAttribute("jsapi_ticket", jsapi_ticket);
			request.setAttribute("timestamp", timestamp);
			request.setAttribute("nonceStr", nonceStr);
			request.setAttribute("signature", signature);
		return null;

	}
}
