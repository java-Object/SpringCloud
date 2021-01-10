package com.lq.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Luo
 * @date 2021/1/9 19:53
 * @Package com.lq.springcloud.config
 * class    spring配置类，用于模拟spring的配置文件
 */

@Configuration  //标记当前类是一个spring配置类，用于模拟spring的配置文件
public class RestTemplateConfig {

    //@Bean 标记当前方法是一个spring配置方法，用于模拟spring配置文件的bean标签
    //相当于在spring容器里面注册 RestTemplate 对象
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
