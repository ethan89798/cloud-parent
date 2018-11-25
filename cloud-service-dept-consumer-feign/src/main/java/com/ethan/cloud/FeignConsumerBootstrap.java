package com.ethan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients 启用Feign进行负载功能,类似面向接口编程
 * @EnableEurekaClient 启用Eureka进行服务发现
 */
@EnableFeignClients(basePackages = {"com.ethan.cloud.feign.service"})
@EnableEurekaClient
@SpringBootApplication
public class FeignConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerBootstrap.class, args);
    }
}
