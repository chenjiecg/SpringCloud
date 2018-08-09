package com.springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcloud.feign.service.impl.SchedualServiceHiHystric;

/**
 * 
 * @author xiaoH
 * @date 2018年8月7日
 * @Description
 */
@FeignClient(value = "eureka-client", fallback= SchedualServiceHiHystric.class)
public interface SchedualServiceHello {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	String sayHelloFromClientOne(@RequestParam(value = "name") String name);
}
