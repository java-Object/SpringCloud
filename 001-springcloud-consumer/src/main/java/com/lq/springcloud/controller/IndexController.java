package com.lq.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luo
 * @date 2021/1/8 11:15
 * @Package com.lq.springcloud.controller
 * class    SpringCloud 消费者 使用 RestTemplate
 */

@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public Map<String,Object> helloSpringCloud(){

        //远程调用，使用RestTemplate对象进行调用
        //RestFul风格的api访问
        //GET：查询
        //POST：新增
        //PUT：修改
        //DELETE：代表删除

        //服务提供者的url地址
        String url = "http://localhost:9200/springcloud/hello";

        /*
            getForEntity 方法返回的是实体对象
                实体对象中包含：状态码、状态值、响应头、响应实体
            getForObject 方法返回的是响应实体
                直接获取响应体中的数据
        */
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);

        HttpStatus statusCode = forEntity.getStatusCode();
        System.out.println("statusCode-------"+statusCode);

        int statusCodeValue = forEntity.getStatusCodeValue();
        System.out.println("statusCodeValue----------" + statusCodeValue);

        String body = forEntity.getBody();
        System.out.println("body----------" + body);

        HttpHeaders headers = forEntity.getHeaders();
        System.out.println("headers-----------" + headers);

        Map<String,Object> map = new HashMap<>();
        map.put("statusCode",statusCode);
        map.put("statusCodeValue",statusCodeValue);
        map.put("body",body);
        map.put("headers",headers);

        /*
           返回结果
        {
            "headers":{
                "Content-Type":["text/plain;charset=UTF-8"],
                "Content-Length":["21"],
                "Date":["Sun, 10 Jan 2021 01:30:29 GMT"],
                "Keep-Alive":["timeout=60"],
                "Connection":["keep-alive"]},
                "statusCodeValue":200,
                "body":"Hello Spring Cloud...",
                "statusCode":"OK"
             }
        */
        return map;
    }

    /**
     * 功能描述:get
     *          getForEntity
     *          getForObject
     *              在进行请求发送的时候需要注意，如果使用传统方式是没有问题的。
     *               方式1：
     *                    localhost:9200/get02/123
     *                方式2：使用了uriVariables，路径变量
     *                    localhost:9200/get02/{id}
     *                    准备map集合，封装id的键值对
     * @Param: []
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Date: 2021/1/10 9:34
     */
    @RequestMapping("/index2")
    public Map<String, Object> getForEntity(){

        String url = "http://localhost:9200/springcloud/hello2/{id}";
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class, map);

        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("statusCode : "+statusCode);

        int statusCodeValue = entity.getStatusCodeValue();
        System.out.println("statusCodeValue : "+statusCodeValue);

        String body = entity.getBody();
        System.out.println("body : "+body);

        HttpHeaders headers = entity.getHeaders();
        System.out.println("headers : "+headers);

        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("headers",headers);
        resultMap.put("statusCode",statusCode);
        resultMap.put("statusCodeValue",statusCodeValue);
        resultMap.put("body",body);
        return resultMap;
    }


    /**
     * 功能描述: post
     *     postForEntity
     *         参数1：url
     *         参数2：请求实体中封装的参数，map集合
     *         参数3：响应的类型的字节码
     *     postForObject
     *          方式1：
     *             localhost:9200/post03，但是，我们进行新增的时候，都是将参数封装到请求实体中
     *             创建一个map集合然后将参数封装到map集合中
     * @Param: []
     * @Return: java.lang.String
     * @Date: 2021/1/10 11:36
     */
    @RequestMapping("/index3")
    public String postForEntiy(){
        String url = "http://localhost:9200/springcloud/post03";
        Map<String,Object> map = new HashMap<>();
        map.put("username","zhangsan");
        String body = restTemplate.postForObject(url,map,String.class);
        return body;
    }

    @RequestMapping("/index4")
    public String put(){
        String url = "http://localhost:9200/springcloud/put04";
        Map<String,Object> map = new HashMap<>();
        map.put("id","1234");
        map.put("username","zhangsan");
        restTemplate.put(url,map,String.class);
        return "put请求发送了！";
    }


    @RequestMapping("/index5")
    public String delete(){

        //RESTFull风格
        String url = "http://localhost:9200/springcloud/delete05/123";
        restTemplate.delete(url);
        return "delete请求发送了！";
    }

}
