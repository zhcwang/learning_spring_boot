package learning.java.spring.springboot.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import learning.java.spring.springboot.mybatis.domin.User;
import learning.java.spring.springboot.mybatis.mapper.UserMapper;
import learning.java.spring.springboot.mybatis.service.UserService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insert(User user) {
		userMapper.insert(user);
		return user.getId();
	}

	@Override
	public List<User> selectAll() {
		return userMapper.getAll();
	}

	@Override
	public User findById(long id) {
		return userMapper.findById(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(long id) {
		userMapper.delete(id);
	}

}
