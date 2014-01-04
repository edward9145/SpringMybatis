package com.web.mapper;

import org.apache.ibatis.annotations.Param;

import com.web.domain.User;

public interface UserMapper {
	
	public User select(String id);
	
	public User selectByUsername(String username);
	
//	@Select("select * from test_user where username=#{username} and pwd=#{password}")
	public User login(@Param("username") String username, @Param("password") String password);
	
	public int insert(User user);
	
	public int remove(String id);
	
	public int update(User user);

}
