package com.lq.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Luo
 * @date 2021/1/9 21:02
 * @Package com.lq.springcloud.controller
 * class 消费者
 */

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){

        //获取提供者的url
        String url = "http://02-springcloud-eureka-client-provider:9200/test";
        return restTemplate.getForEntity(url,String.class).getBody()+"-------带有注册中心的服务消费者";
    }
}
