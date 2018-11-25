package com.ethan.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义轮询规则类
 */
public class CustomRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object key) {
        return choose(this.getLoadBalancer(), key);
    }

    private AtomicInteger count = new AtomicInteger(0);
    private AtomicInteger index = new AtomicInteger(0);

    private Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        List<Server> reachableList = lb.getReachableServers();
        List<Server> allList = lb.getAllServers();
        if (allList.size() == 0) {
            return null;
        }

        while (server == null) {
            if (count.getAndIncrement() < 5) {
                reachableList.get(index.get());
            } else {
                if (index.incrementAndGet() > reachableList.size()) {
                    index.set(0);
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            } else {
                if (server.isAlive()) {
                    return server;
                }
                server = null;
                Thread.yield();
            }
        }

        return server;
    }
}
