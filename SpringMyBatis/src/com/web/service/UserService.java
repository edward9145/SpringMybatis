package com.web.service;

import org.springframework.transaction.annotation.Transactional;

import com.web.domain.User;

public interface UserService {
	
	public User login(String username, String password);

	public User json(String id);

	@Transactional
	public String register(User user);

	public String update(User user);

	public String remove(String id);
	

}
