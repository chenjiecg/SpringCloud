package com.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.ribbon.service.HelloService;

/**
 * 
 * @author xiaoH
 * @date 2018年8月7日
 * @Description
 */
@RestController
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping(value = "/test")
	public String test(@RequestParam String name) {
		
		return helloService.testService(name);
	}
}
