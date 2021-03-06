package com.springcloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author xiaoH
 * @date 2018年8月7日
 * @Description
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);

	}

	
	@Value("${server.port}")
    String port;

    @RequestMapping("/test")
    public String home(@RequestParam(value = "name", defaultValue = "xiaoH") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
