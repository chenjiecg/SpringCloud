package com.springcloud.config.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * @author xiaoH
 * @date 2018年8月9日
 * @Description
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigEurekaServerApplication.class, args);
	}

}
