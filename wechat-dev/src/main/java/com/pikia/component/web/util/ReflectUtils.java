package com.pikia.component.web.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pikia.wx.util.WeixinUtil;

/**
 * 反射工具类
 * 
 * @author Methew
 * 
 */
public class ReflectUtils {
	private static Logger log = LoggerFactory.getLogger(ReflectUtils.class);

	public static String memberVariable2String(Object obj) {
		Class clazz = obj.getClass();
		Method method = null;
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		do {
			Field[] fields = clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if (i != 0)
					buffer.append(",");
				String fieldName = fields[i].getName();
				String upperName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					method = clazz.getMethod("get" + upperName);
					String value = String.valueOf(method.invoke(obj));
					buffer.append(fields[i].getName() + "=" + value);
				} catch (NoSuchMethodException e) {
					log.error("**** ReflectUtils error ", e);
				} catch (SecurityException e) {
					log.error("**** ReflectUtils error ", e);
				} catch (IllegalAccessException e) {
					log.error("**** ReflectUtils error ", e);
				} catch (IllegalArgumentException e) {
					log.error("**** ReflectUtils error ", e);
				} catch (InvocationTargetException e) {
					log.error("**** ReflectUtils error ", e);
				}
			}
			clazz = clazz.getSuperclass();
		} while (clazz != Object.class);
		buffer.append("]");
		return buffer.toString();
	}
}
