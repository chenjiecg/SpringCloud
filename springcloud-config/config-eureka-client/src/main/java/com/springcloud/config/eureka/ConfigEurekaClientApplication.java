package com.springcloud.config.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @author xiaoH
 * @date 2018年8月9日
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigEurekaClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigEurekaClientApplication.class, args);
	}
}
