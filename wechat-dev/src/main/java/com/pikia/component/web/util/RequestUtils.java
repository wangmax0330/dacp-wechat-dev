package com.pikia.component.web.util;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class RequestUtils {
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	public static String getUrl(HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		StringBuffer sb = new StringBuffer(requestUrl);
		Map params = request.getParameterMap();
		Iterator it = params.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String val = request.getParameter(key);
			sb.append("&").append(key).append("=").append(val);
		}
		return sb.toString();
	}

	public static String requestUrl(HttpServletRequest request) {
		String queryString = request.getQueryString();
		if (StringUtils.isNotBlank(queryString)) {
			return request.getRequestURL().append("?").append(request.getQueryString()).toString();
		}
		return request.getRequestURL().toString();
	}
}
