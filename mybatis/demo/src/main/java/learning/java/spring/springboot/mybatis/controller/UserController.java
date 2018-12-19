package learning.java.spring.springboot.mybatis.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.mybatis.domin.User;
import learning.java.spring.springboot.mybatis.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("add")
	public Object add() {
		User user = new User();
		user.setAge(11);
		user.setName("test");
		user.setPhone("10010");
		user.setCreateTime(new Date());
		return userService.insert(user);
	}
	@GetMapping("selectAll")
	List<User> selectAll(){
		return userService.selectAll();
	};
	@GetMapping("findById")
	User findById(){
		return userService.findById(21);
	};
	@GetMapping("update")
	String update(){
		User user = new User();
		user.setId(19);
		user.setAge(11);
		user.setName("19");
		user.setPhone("10086");
		user.setCreateTime(new Date());
		userService.update(user);
		return "success";
	};
	@GetMapping("delete")
	String delete(){
		userService.delete(18);
		return "success";
	};
}
	
