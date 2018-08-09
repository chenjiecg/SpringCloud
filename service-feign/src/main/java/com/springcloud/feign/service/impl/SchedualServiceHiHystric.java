package com.springcloud.feign.service.impl;

import org.springframework.stereotype.Component;

import com.springcloud.feign.service.SchedualServiceHello;

/**
 * 
 * @author xiaoH
 * @date 2018年8月7日
 * @Description
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHello {

	@Override
	public String sayHelloFromClientOne(String name) {
		// TODO Auto-generated method stub
		return "Sorry," + name;
	}

}
