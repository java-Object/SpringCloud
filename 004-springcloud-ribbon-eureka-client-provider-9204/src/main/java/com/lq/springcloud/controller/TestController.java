package com.lq.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo
 * @date 2021/1/10 14:02
 * @Package com.lq.springcloud.controller
 * class
 */

@RestController
@RequestMapping("/service")
public class TestController {

    @RequestMapping("/01")
    public Object service01(){
        return "service 01 execute 9204";
    }

}
