package com.lq.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Luo
 * @date 2021/1/9 21:00
 * @Package com.lq.springcloud.config
 * class
 */

@Configuration
public class RestTemplateConfig {

    //使用 Ribbon 的负载均衡从注册中心获取服务
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
