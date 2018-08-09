package com.springcloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

/**
 * 
 * @author xiaoH
 * @date 2018年8月7日
 * @Description
 */
@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloError")
	public String testService(String name) {
		return restTemplate.getForObject("http://eureka-client/test?name=" + name, String.class);
	}
	
	public String helloError(String name){
		
		return "Hi," + name + ", Sorry Error!";
	}
}
