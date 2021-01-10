package com.lq.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo
 * @date 2021/1/10 15:40
 * @Package com.lq.springcloud.controller
 * class
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping("/01")
    public Object service01(){
        return "service 01 execute ...";
    }

    //模拟异常演示
    @RequestMapping("/error")
    public Object error(){

        int i = 10/0;

        return "error execute ...";
    }

    //模拟阻塞，超时异常
    @RequestMapping("/timeout")
    public Object timeout() throws InterruptedException {

        Thread.sleep(5000);

        return "timeout execute ...";
    }

}
