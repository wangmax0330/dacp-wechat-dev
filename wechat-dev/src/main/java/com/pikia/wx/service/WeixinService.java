package com.pikia.wx.service;

import javax.servlet.http.HttpServletRequest;

import com.pikia.wx.domain.AccessToken;

public interface WeixinService {
	// 缓存查询accessToken
	public AccessToken checkOutAccessToken();

	public void sendDecoratorProgessMessage(String touser, String originalUrl, String projectId, String sectionType);

	// 调用微信js_jdk 的配置,sortUrl 是controller 的映射路径
	public Object setWechatProperties_JS_JDK(HttpServletRequest request, String shortUrl);
}
