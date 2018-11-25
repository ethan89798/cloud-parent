package com.ethan.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡类
 */
@Configuration
public class CustomRuleConfiguration {

    /**
     * 每个服务调用5次,再切换服务器
     */
    @Bean
    public IRule rule() {
        return new RandomRule();//随机
    }
}
