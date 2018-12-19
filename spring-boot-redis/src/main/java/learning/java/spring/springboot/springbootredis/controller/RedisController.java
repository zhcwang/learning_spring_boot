package learning.java.spring.springboot.springbootredis.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.springbootredis.domin.JsonData;
import learning.java.spring.springboot.springbootredis.domin.User;
import learning.java.spring.springboot.springbootredis.utils.JsonUtils;
import learning.java.spring.springboot.springbootredis.utils.RedisClient;

@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
	private StringRedisTemplate redisTpl; //jdbcTemplate
	
	@Autowired
	private RedisClient redisClient;

	@GetMapping(value="add")
	public Object add(){
		
		//opsForValue : Returns the operations performed on simple values (or Strings in Redis terminology).
		String name = "zcwang";
		redisTpl.opsForValue().set("name", name);
 		redisTpl.opsForList().set("names", 1, "1");
 		redisTpl.opsForList().set("names", 2, "2");
 		redisTpl.opsForList().set("names", 3, "3");
 		redisTpl.opsForList().set("names", 3, "3");
 		Map<String, String> ages = new HashMap<>();
 		ages.put("zcwang", "29");
 		ages.put("chenyan", "28");
 		redisTpl.opsForHash().putAll("ages", ages);
		return "success";
		
	}
	
	@GetMapping(value="get")
	public Object get(){
		
		String value = redisTpl.opsForValue().get("name");		
		return value;
		
	}
	
	@GetMapping(value="save_user")
	public Object saveUser(){
		User user = new User(1, "abc", "11", new Date());
		String userStr = JsonUtils.obj2String(user);
		boolean flag = redisClient.set("base:user:11", userStr);
		return JsonData.buildSuccess(flag);
		
	}
	
	@GetMapping(value="find_user")
	public Object findUser(){

		String userStr = redisClient.get("base:user:11");
		User user = JsonUtils.string2Obj(userStr, User.class);
		
		return JsonData.buildSuccess(user);
		
	}
	
}
