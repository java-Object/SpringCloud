package com.lq.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Luo
 * @date 2021/1/9 20:50
 * @Package com.lq.springcloud.controller
 * class 使用 Eureka --- 提供者
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "使用了eureka注册中心的服务提供者！";
    }
}
