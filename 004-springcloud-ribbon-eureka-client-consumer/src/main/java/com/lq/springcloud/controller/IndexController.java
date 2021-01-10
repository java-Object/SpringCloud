package com.lq.springcloud.controller;

import com.lq.springcloud.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Luo
 * @date 2021/1/10 14:31
 * @Package com.lq.springcloud.controller
 * class Ribbon -- 消费者
 */

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    //生明式消费者
    @Autowired
    private ProviderFeign providerFeign;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/01")
    public Object index01(){

        //在服务注册到注册中心时，是将服务名称和地址进行绑定，我们可以通过服务名称
        //进行远程调用。
//        String url = "http://004-springcloud-ribbon-eureka-client-provider/service/01";
//        String forObject = restTemplate.getForObject(url, String.class);

        String url = "http://004-SPRINGCLOUD-RIBBON-EUREKA-CLIENT-PROVIDER/service/01";
        String body = restTemplate.getForObject(url, String.class);

        List<ServiceInstance> instances = discoveryClient.getInstances("004-SPRINGCLOUD-RIBBON-EUREKA-CLIENT-PROVIDER");

        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId());
        }



        return "执行完成";

    }



}
