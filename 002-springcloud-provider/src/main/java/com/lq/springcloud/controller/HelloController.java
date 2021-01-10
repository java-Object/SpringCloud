package com.lq.springcloud.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Luo
 * @date 2021/1/9 19:44
 * @Package com.lq.springcloud.controller
 * class SpringCloud快速入门-提供者
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello Spring Cloud...";
    }

    @RequestMapping(value = "/hello2/{id}")
    public String hello2(@PathVariable String id){
        return "Hello Spring Cloud..."+id;
    }

    /**
     * post请求方式将参数封装到了请求实体中，@RequestBody从请求实体中获取username参数
     *      映射到形参中
     * @param username
     * @return
     */
    @RequestMapping("/post03")
    public String post03(@RequestBody String username){
        return "username : "+username;
    }

    @RequestMapping("/put04")
    public void put04(@RequestBody Map map){
        System.out.println("map : " + map);
    }

    @RequestMapping("/delete05/{id}")
    public void delete(@PathVariable String id){
        System.out.println("id : " + id);
    }

}
