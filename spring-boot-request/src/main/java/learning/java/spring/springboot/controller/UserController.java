package learning.java.spring.springboot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.controller.dto.User;

@RestController
public class UserController {
	private Map<String, String> userMap = new HashMap<>();
	/**
	 * REST路径参数
	 * @param userName
	 * @param age
	 * @return
	 */
	@RequestMapping(path = "/getUser/{name}/{age}", method = RequestMethod.GET)
	public Map<String, String> getUser(@PathVariable("name") String userName,
							@PathVariable String age){
		userMap.put(userName, age);
		return userMap;
	}
	
	/**
	 * GET请求URL参数
	 * @param name
	 * @param age
	 * @return
	 */
	@GetMapping("getUserMap")
	public Map<String, String> getUserMap(@RequestParam(defaultValue="chenyan", name="name",required=false) String name, String age){
		userMap.clear();
		userMap.put(name, age);
		return userMap;
	}
	
	/**
	 * 直接反序列化body里面的JSON
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/saveUser", method = RequestMethod.POST)
	public Map<String, String> saveUser(@RequestBody User user){
		userMap.clear();
		userMap.put(user.getName(), user.getAge());
		return userMap;
	}
	
	/**
	 * 获取HTTP请求的头信息
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/getHeader", method = RequestMethod.GET)
	public Object getHeader(@RequestHeader("access_token") String accessToken){
		return accessToken;
	}
	
	/**
	 * 获取HTTP请求的头信息
	 * @param user
	 * @return
	 */
	@GetMapping("/testRquest")
	public Object testRquest(HttpServletRequest request){
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		userMap.clear();
		userMap.put(name, age);
		return userMap;
	}
	/**
	 * POST表单提交
	 * @param name
	 * @param age
	 * @return
	 */
	@PostMapping("/testPost")
	public Object testPost(String name, String age){
		userMap.clear();
		userMap.put(name, age);
		return userMap;
	}
	
	/**
	 * PUT 参数提交
	 * @param name
	 * @param age
	 * @return
	 */
	@PutMapping("/testPut")
	public String testPut(String name){
		return name;
	}
	
	/**
	 * DELETE 参数提交
	 * @param name
	 * @param age
	 * @return
	 */
	@DeleteMapping("/testDelete")
	public String testDelete(String name){
		return name;
	}
	@GetMapping("/testJson")
	public User testJson() {
		return new User("id", "name", "age", "account", "pwd", new Date());
	} 
	
}