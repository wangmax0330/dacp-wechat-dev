package com.pikia.component.cache.handler;

import java.util.Hashtable;

/**
 * 不推荐使用,因为在进行读操作的时候,依然是可以写入数据,造成读操作数据过期
 * 
 * @author Methew
 * 
 */
public class BaseCacheHandler_inappropriate {
	public static Hashtable<String, Object> cacheContext = new Hashtable<String, Object>();

	/**
	 * 
	 * @param cacheName
	 * @param cacheObject
	 * @param time
	 * @param callBack
	 */
	public static synchronized void put(String cacheName, Object cacheObject, long time, CacheCallBack callBack) {
		cacheContext.put(cacheName, cacheObject);
		if (time != -1) {
			// 启动自动销毁线程,多久之后销毁缓存对象
			new CacheListener(cacheName, time, callBack).start();
		}
	}

	public static Object get(String cacheName) {
		return cacheContext.get(cacheName);
	}

	public synchronized static void clearCache() {
		cacheContext.clear();
	}
}
