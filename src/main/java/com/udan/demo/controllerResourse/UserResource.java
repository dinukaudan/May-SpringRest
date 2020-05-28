package com.udan.demo.controllerResourse;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udan.demo.controller.UserController;
import com.udan.demo.exception.UserNotFoundException;
import com.udan.demo.model.User;

@RestController
public class UserResource {
	
	@Autowired
	private UserController userController;
	
	@GetMapping("findall")
	public List<User> findall() {
		return userController.findAll();
	}
	
	@GetMapping("user/{id}")
	public User findone(@PathVariable int id) {
		User userf=userController.findOne(id);
		if(userf==null) {
			throw new UserNotFoundException("id : "+id+"shala lala laa haii shalala in the evening");
			
		}
		return  userf;
	}
	
	
	@DeleteMapping("user/{id}")
	public ResponseEntity<Object> deleteone(@PathVariable int id) {
		User userf=userController.deleteOne(id);
	URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@PostMapping("user")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser= userController.saveUser(user);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
