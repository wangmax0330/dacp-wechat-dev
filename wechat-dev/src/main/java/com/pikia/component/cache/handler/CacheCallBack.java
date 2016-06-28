package com.pikia.component.cache.handler;

/**
 * 缓存对象销毁
 * 
 * @author Methew
 * 
 */
public interface CacheCallBack {
	/*
	 * 缓存对象销毁之前
	 */
	public void onCacheObjectDestory(Object object);

	/*
	 * 缓存对象销毁之后
	 */
	public void onCacheObjectDestoryed();
}
