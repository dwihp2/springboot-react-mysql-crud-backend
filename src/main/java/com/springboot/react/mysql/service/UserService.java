package com.springboot.react.mysql.service;

import com.springboot.react.mysql.model.User;
import com.springboot.react.mysql.model.UserDto;

import java.util.List;

public interface UserService {
	
	User save(UserDto user);
		List<User> findAll();
		void delete(int id);
		
		User findOne(String username);
		
		User findById(int id);
		
		UserDto update(UserDto userDto);

}
