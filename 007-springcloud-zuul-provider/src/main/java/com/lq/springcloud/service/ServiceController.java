package com.lq.springcloud.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ServiceController
 * PackageName:com.bjpowernode.springcloud.service
 * Description:
 *
 * @date 2021/1/8 14:55
 * @author: 动力节点
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping("/01")
    public Object service01(){
        return "service 01 execute ...";
    }

}
