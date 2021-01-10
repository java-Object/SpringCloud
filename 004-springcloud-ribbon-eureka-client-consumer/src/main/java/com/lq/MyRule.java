package com.lq;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Luo
 * @date 2021/1/10 14:11
 * @Package com.lq
 * class  定义自己的 ribbon 负载均衡策略
 */

@Configuration
public class MyRule {

    @Bean
    public IRule randomRule(){
        //随机负载均衡策略
        return new RandomRule();
    }

}
