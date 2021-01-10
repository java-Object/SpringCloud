package com.lq.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Luo
 * @date 2021/1/10 14:14
 * @Package com.lq.springcloud.config
 * class  设置 RestTemplate 对象到spring容器
 */

@Configuration
public class RestTemplateConfig {

    //查看官网提供信息：
    //如果想要修改其他的负载均衡策略
    //你需要这样加载，不能将这个负载均衡策略写在ComponentScan能够扫描的路径下
    //要另外去进行加载
    //想要实现其他的负载均衡策略，只需要将对应的负载均衡实现类交给spring容器进行管理即可
    //ComponentScan默认在@SpringBootApplication
    //也就是说我们不能够将负载均衡策略写在引导类能够扫描的路径下
//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
