package learning.java.spring.springboot.mybatis.service;

import java.util.List;

import learning.java.spring.springboot.mybatis.domin.User;

public interface UserService {
	int insert(User user);
	
	List<User> selectAll();
	
	User findById(long id);
	
	void update(User uesr);
	
	void delete(long id);
}
