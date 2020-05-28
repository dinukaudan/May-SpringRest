package com.udan.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udan.demo.model.User;

@Component 
public class UserController {

	private static List<User> userList= new ArrayList<>();
	public static int  usercount=3;
	
	static {
	userList.add(new User(1,"dinuka",new Date()));

	userList.add(new User(2,"vishmi",new Date()));

	userList.add(new User(3,"nadun",new Date()));
		
	}
	
	
	public List<User> findAll(){
		return userList;
	}
	
	
	public User findOne( int userId) {
		for (User user : userList) {
			if (user.getId()==userId) {
				return user;
			
			}
		}
		return null;
	}
	
	public User saveUser( User user) {
		if(user.getId()==null) {
			usercount++;	
			user.setId(usercount);
		}
	userList.add(user);
	return user;
	}
}
