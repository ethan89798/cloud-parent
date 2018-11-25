package com.ethan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @EnableDiscoveryClient 启动服务发现
 * @EnableEurekaClient 启动eureka服务注册
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class DeptBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(DeptBootstrap.class, args);
    }
}
