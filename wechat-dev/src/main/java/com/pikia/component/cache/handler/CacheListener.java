package com.pikia.component.cache.handler;

public class CacheListener extends Thread {
	private String name; // 缓存对象名称
	private long time; // 缓存对象时间
	private CacheCallBack callBack;// 缓存回调函数

	// 缓存监听器构造
	public CacheListener(String name, long time, CacheCallBack callBack) {
		this.name = name;
		this.time = time;
		this.callBack = callBack;
	}

	// 启动缓存时间线程
	public void run() {
		try {
			Thread.sleep(time);
			Object o = BaseCacheHandler_inappropriate.cacheContext.get(name);
			if (callBack != null) {
				// 回调,销毁之前
				callBack.onCacheObjectDestory(o);
				// 销毁对象
				BaseCacheHandler_inappropriate.cacheContext.remove(name);
				// 回调,销毁之后
				callBack.onCacheObjectDestoryed();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
