package com.pikia.component.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;

import com.pikia.wx.service.impl.WeixinServiceImpl;

public class SystemProperties {
	protected final Logger logger = Logger.getLogger(SystemProperties.class);
	private static Properties pro;
	private static SystemProperties sp = new SystemProperties();

	public static String getProperties(String key) {
		return pro.getProperty(key);
	}

	/**
	 * 创建一个新的实例 SystemProperties.
	 * 
	 */
	private SystemProperties() {
		// InputStream inputStream =
		// this.getClass().getClassLoader().getResourceAsStream("resource/wechat.properties");
		InputStream inputStream = SystemProperties.class.getClassLoader().getResourceAsStream("config/wechat-demo.properties");
		try {
			if (inputStream != null) {
				// InputStreamReader转换流 该流对象中可以对读取到的字节数据进行指定编码的编码转换。
				// this.pro.load(new InputStreamReader(inputStream, "utf-8"));
				pro = new Properties();
				pro.load(inputStream);
			} else {
				logger.error("inputStream 为null  找不到该资源文件");
			}
		} catch (IOException e1) {
			logger.error(e1);
		}
	}
}
