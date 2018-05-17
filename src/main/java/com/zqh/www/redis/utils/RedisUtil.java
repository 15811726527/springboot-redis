package com.zqh.www.redis.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

//@SuppressWarnings("rawtypes")
//@SuppressWarnings("unchecked")
@SuppressWarnings({"rawtypes","unchecked"})
@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class RedisUtil {

	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * set(K key, V value) 新增一个字符串类型的值,key是键，value是值。
	 */

	public void set(Object key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * get(Object key) 获取key键对应的值。
	 */

	public Object get(Object key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * get(K key, long start, long end)
	 * 截取key键对应值得字符串，从开始下标位置开始到结束下标的位置(包含结束下标)的字符串。
	 */

	public String get(Object key, long start, long end) {
		return redisTemplate.opsForValue().get(key, start, end);
	}

	/**
	 * getAndSet(K key, V value) 获取原来key键对应的值并重新赋新值。
	 */
	public Object getAndSet(Object key, Object value) {
		return redisTemplate.opsForValue().getAndSet(key, value);
	}

	/**
	 * size(K key) 获取指定字符串的长度。
	 */
	public Long size(Object key) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		return opsForValue.size(key);
	}

	/**
	 * increment(K key, double delta) 以增量的方式将double值存储在变量中。
	 * 
	 */
	public double increment(Object key, double delta) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		return opsForValue.increment(key, delta);
	}

	/**
	 * increment(K key, long delta) 以增量的方式将long值存储在变量中。
	 * 
	 */
	public double increment(Object key, long delta) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		return opsForValue.increment(key, delta);
	}

	/**
	 * set(K key, V value, long timeout, TimeUnit unit) 设置变量值的过期时间。。
	 * 
	 */
	public void set(Object key, Object value, long timeout, TimeUnit unit) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.set(key, value, timeout, unit);
	}

	/**
	 * set(K key, V value, long offset) 覆盖从指定位置开始的值。
	 * 
	 */
	public void set(Object key, Object value, long offset) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.set(key, value, offset);
	}

	/**
	 * multiSet(Map<? extends K,? extends V> map) 设置map集合到redis。
	 * 
	 */
	public void multiSet(Map<Object, Object> map) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.multiSet(map);
	}

	/**
	 * multiGet(Collection<K> keys) 根据集合取出对应的value值。
	 * 
	 */
	public List<String> multiGet(Collection<Object> keys) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		return opsForValue.multiGet(keys);
	}

	/**
	 * multiSetIfAbsent(Map<? extends K,? extends V> map)
	 * 如果对应的map集合名称不存在，则添加，如果存在则不做修改。
	 * 
	 */
	public void multiSetIfAbsent(Map<Object, Object> map) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.multiSetIfAbsent(map);
	}

}
