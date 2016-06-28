package com.pikia.component.cache.handler;

import com.pikia.component.web.util.ReflectUtils;

public class CacheObject {
	@Override
	public String toString() {
		// 这里不能直接使用CacheObject.class,需要获取的是子类的属性值
		return ReflectUtils.memberVariable2String(this);
	}
}
