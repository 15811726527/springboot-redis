package com.zqh.www.redis.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zqh.www.redis.utils.RedisUtil;

@RestController("redisController")
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisUtil redisUtil;

	@GetMapping("/demo")
	private void demo() {
		redisUtil.set("1", "1", 10, TimeUnit.SECONDS);
		redisUtil.set("2", 1, 10, TimeUnit.SECONDS);
		Object object = redisUtil.get("1");
		Object object2 = redisUtil.get("2");
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("3", "2");
		map.put("4", "3");
		redisUtil.multiSet(map);
		System.out.println(object2);
		ArrayList<Object> arrayList = new ArrayList<>();
		arrayList.add("3");
		arrayList.add("4");
		List<String> multiGet = redisUtil.multiGet(arrayList);
		System.out.println(multiGet);
	}
}
