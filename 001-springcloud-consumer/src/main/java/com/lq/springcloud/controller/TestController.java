package com.lq.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Luo
 * @date 2021/1/9 19:59
 * @Package com.lq.springcloud.controller
 * class 消费者，调用提供者
 */

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){

        //提供者的方法访问地址
        String url = "http://localhost:9200/springcloud/hello";

        //访问远程的 SpringCloud 服务
        return restTemplate.getForEntity(url,String.class).getBody() + "-------SpringCloud的消费者";
        //成功！！！！
    }


}
