package com.web.service.impl;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.domain.User;
import com.web.mapper.UserMapper;
import com.web.service.UserService;
import com.web.util.Str;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		return userMapper.login(username, password);
	}

	@Override
	public User json(String id) {
		return userMapper.select(id);
	}

	@Override
	public String register(User user) {
		if(userMapper.selectByUsername(user.getUsername()) != null)
			return Str.name_existed;
		
		user.setId("" + new Random().nextInt(100000));
		userMapper.insert(user);
		return user.getId();
	}

	@Override
	public String update(User user) {
		userMapper.update(user);
		return user.getId();
	}

}
