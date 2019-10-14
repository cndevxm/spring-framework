package com.cndevxm.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping(value = "/sayHello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String sysHello(@RequestParam String name) {
		System.out.println("Hello :" + name);
		return "Hello :" + name;
	}
}
