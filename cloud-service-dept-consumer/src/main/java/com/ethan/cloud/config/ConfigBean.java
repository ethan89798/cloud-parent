package com.ethan.cloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @LoadBalanced 增加负载均衡
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 负载的规则ribbon提供的有以下几种:
     * 1) RoundRobinRule
     *    轮询
     * 2) RandomRole
     *    随机
     * 3) AvailabilityFilteringRule
     *    将故障多处于断路器和并发超过阈值的服务过滤掉,对剩下的服务列表进行轮询
     * 4) WeightedResponseTimeRule
     *    根据平均响应时间计算权重,响应越快权利越大,选中概率越大.
     *    刚上线因统计信息不足,而走RoundRobinRule轮询,等统计信息足够就会切换回WeightedResponseTimeRule
     * 5) RetryRule
     *    先RoundRobinRule获取服务, 如果获取失败则在指定时间内重试,获取可用的服务
     * 6) BestAvailableRule
     *    将故障多处于断路器的服务过滤掉,然后选择一个并发量比较小的服务
     * 7) ZoneAvoidanceRule
     *    复合判断server所在的区域的性能和server的可用性选择服务
     */
    @Bean
    public IRule rule() {
        // 将故障多处于断路器和并发超过阈值的服务过滤掉,对剩下的服务列表进行轮询
//        return new AvailabilityFilteringRule();
        // 根据平均响应时间计算权重,响应越快权利越大,选中概率越大.
        // 刚上线因统计信息不足,而走RoundRobinRule轮询,等统计信息足够就会切换回WeightedResponseTimeRule
//        return new WeightedResponseTimeRule();
        // 先RoundRobinRule获取服务, 如果获取失败则在指定时间内重试,获取可用的服务
//        return new RetryRule();
        // 将故障多处于断路器的服务过滤掉,然后选择一个并发量比较小的服务
//        return new BestAvailableRule();
        // 复合判断server所在的区域的性能和server的可用性选择服务
//        return new ZoneAvoidanceRule();
        //使用随机负载算法,来覆盖原来默认的轮询算法
        return new RandomRule();
    }
}
