package com.cndevxm.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping(value = "/sayHello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String sysHello(@RequestParam String name) {
		System.out.println("Hello :" + name);
		return "Hello :" + name;
	}

	/**
	 * 基于uri的映射
	 *
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/sayHello/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String sysHelloByUri(@PathVariable("name") String name) {
		System.out.println("Hello :" + name);
		return "Hello :" + name;
	}

	/**
	 * 基于正则表达式uri的映射
	 *
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
	public String sysHelloByUri(@PathVariable("name") String name, @PathVariable("version") String version) {
		System.out.println("Hello :" + name);
		return "Hello :" + name;
	}
}
