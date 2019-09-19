package com.cndevxm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/sayHello")
	public String sysHello(String name) {
		System.out.println("Hello :" + name);
		return "Hello :" + name;
	}
}
