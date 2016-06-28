package com.pikia.component.cache;

import java.util.Map;

//1.缓存控制器
//2.缓存监听器
//3.缓存回调接口

public interface Cache<K, V> {
	public String getName();

	public V get(K key);

	public void put(K key, V value);


	public void putAll(Map<? extends K, ? extends V> entries);

	public boolean isEmpty();

	public int size();

	public void clear();

}