package com.lq.springcloud.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Luo
 * @date 2021/1/10 16:52
 * @Package com.lq.springcloud.controller
 * class
 */

@RestController
public class ServiceController {


    @RequestMapping("/helloSpringCloud")
    public String helloSpringCloud(){
        return "helloSpringCloud";
    }

    @GetMapping("/get02/{id}")
    public String helloSpringCloud(@PathVariable String id){
        return "helloSpringCloud  " + id;
    }

    @PostMapping("/post03")
    public String post03(@RequestBody String username){
        return "username : "+username;
    }

    @PutMapping("/put04")
//    public void put04(@RequestBody Map map){
    public Object put04(@RequestBody Map map){
        System.out.println("map ："+map);
        return map;
    }

    @DeleteMapping(value = "/delete05/{id}")
//    public void put04(@PathVariable String id){
    public Object put04(@PathVariable String id){
        System.out.println("id ："+id);
        return id;
    }

}
