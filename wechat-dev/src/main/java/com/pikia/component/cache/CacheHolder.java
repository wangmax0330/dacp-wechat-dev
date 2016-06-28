package com.pikia.component.cache;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.pikia.component.cache.handler.BaseCacheHandler;
import com.pikia.component.cache.handler.CacheObject;

public class CacheHolder implements Cache {
	protected final Logger logger = Logger.getLogger(BaseCacheHandler.class);
	private final ReadWriteLock rwl;
	public Hashtable<String, CacheObject> cacheContext;

	public CacheHolder() {
		cacheContext = new Hashtable<String, CacheObject>();
		rwl = new ReentrantReadWriteLock();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object key) {
		rwl.readLock().lock(); // 读锁开启，读线程均可进入
		try { // 用try finally来防止因异常而造成的死锁
			if (logger.isDebugEnabled())
				logger.info(" CacheHolder try to read the cacheContext on  key:  " + key);
			return cacheContext.get(key);
		} finally {
			rwl.readLock().unlock(); // 读锁解锁
		}
	}

	public void put(CacheObject value) {
		rwl.writeLock().lock(); // 写锁开启，这时只有一个写线程进入
		try {
			if (logger.isDebugEnabled())
				logger.info(" CacheHolder try to put the data in cacheContext:  " + value);
			this.cacheContext.put(value.getClass().getName(), value);
		} finally {
			rwl.writeLock().unlock(); // 写锁解锁
		}
	}

	@Override
	public void putAll(Map entries) {

	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public void clear() {
	}

	@Override
	public void put(Object key, Object value) {

	}

}
