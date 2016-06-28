package com.pikia.wx.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.pikia.component.cache.handler.CacheObject;

public class AccessToken extends CacheObject {

	// 获取到的凭证
	private String token;
	// 凭证有效时间，单位：秒
	private int expiresIn;

	private Date createTime;

	// jsapi_ticket是公众号用于调用微信JS接口的临时票据jsapi_ticket的有效期为7200秒
	private String jsapiTicket;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getJsapiTicket() {
		return jsapiTicket;
	}

	public void setJsapiTicket(String jsapiTicket) {
		this.jsapiTicket = jsapiTicket;
	}

	public static void main(String[] args) {
		AccessToken token = new AccessToken();
		token.setCreateTime(new Date());
		token.setExpiresIn(12);
		token.setToken("1212312312");
		System.out.println(token);
	}
}