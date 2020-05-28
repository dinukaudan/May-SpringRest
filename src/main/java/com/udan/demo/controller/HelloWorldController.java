package com.udan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udan.demo.model.HelloBean;

@RestController
public class HelloWorldController {

	@GetMapping("hello")
	public String helloController() {
		return "Hello World";
	}
	@GetMapping("hellobean")
	public HelloBean helloBeanController() {
		return new HelloBean("Hello World, This is a new bean class");
	}
	@GetMapping("hellobean/{name}")
	public HelloBean helloBeanPath(@PathVariable String name) {
		return new HelloBean(String.format("Hello World , %s", name));
	}
	


}
