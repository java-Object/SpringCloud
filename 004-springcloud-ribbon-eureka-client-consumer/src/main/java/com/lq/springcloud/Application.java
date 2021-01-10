package com.lq.springcloud;

import com.lq.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
//设置负载均衡策略
@RibbonClient(name = "004-springcloud-ribbon-eureka-client-provider",configuration = MyRule.class)
@EnableEurekaClient
// 声明这是 Feign 的客户端
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
