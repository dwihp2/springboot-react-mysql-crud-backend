package com.springboot.react.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.springboot.react.mysql.model.ApiResponse;
import com.springboot.react.mysql.model.User;
import com.springboot.react.mysql.model.UserDto;
import com.springboot.react.mysql.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ApiResponse<User> saveUser(@RequestBody UserDto user){
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully", userService.save(user));
	}
	
	@GetMapping
	public ApiResponse<List<User>> listUser(){
		return new ApiResponse<>(HttpStatus.OK.value(),"User list fetched succesfully", userService.findAll());
	}
	
	@GetMapping("/{id}")
	public ApiResponse<User> getOne(@PathVariable int id) {
		return new ApiResponse<>(HttpStatus.OK.value(),"User fetched successfully", userService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ApiResponse<UserDto> update(@RequestBody UserDto userDto){
		return new ApiResponse<>(HttpStatus.OK.value(),"User update successfully", userService.update(userDto));
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse<Void> delete(@PathVariable int id){
		return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully", null);
	}
	

}
