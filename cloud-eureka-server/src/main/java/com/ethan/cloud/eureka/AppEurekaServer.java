package com.ethan.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer 开启Eureka服务注册服务器,类型于Zookeeper
 */
@EnableEurekaServer
@SpringBootApplication
public class AppEurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(AppEurekaServer.class, args);
    }
}
