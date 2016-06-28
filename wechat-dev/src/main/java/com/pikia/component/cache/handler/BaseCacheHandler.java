package com.pikia.component.cache.handler;

import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;

import com.pikia.wx.controller.WeixinController;
import com.pikia.wx.domain.AccessToken;

public class BaseCacheHandler {
	protected final Logger logger = Logger.getLogger(BaseCacheHandler.class);

	private final ReadWriteLock rwl;
	public Hashtable<String, CacheObject> cacheContext;

	public BaseCacheHandler() {
		cacheContext = new Hashtable<String, CacheObject>();
		rwl = new ReentrantReadWriteLock();
	}

	public Object get(String key) {
		rwl.readLock().lock(); // 读锁开启，读线程均可进入
		try { // 用try finally来防止因异常而造成的死锁
			if (logger.isDebugEnabled())
				logger.info(" BaseCacheHandler try to read the cacheContext on  key:  " + key);
			return cacheContext.get(key);
		} finally {
			rwl.readLock().unlock(); // 读锁解锁
		}
	}

	public void put(CacheObject data) {
		rwl.writeLock().lock(); // 写锁开启，这时只有一个写线程进入
		try {
			if (logger.isDebugEnabled())
				logger.info(" BaseCacheHandler try to put the data in cacheContext:  " + data);
			this.cacheContext.put(data.getClass().getName(), data);
		} finally {
			rwl.writeLock().unlock(); // 写锁解锁
		}
	}

	public static void main(String[] args) {
		AccessToken token = new AccessToken();
		System.out.println(token.getClass().getPackage().getName());
		System.out.println(token.getClass().getName());
	}
}
