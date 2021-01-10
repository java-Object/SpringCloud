package com.lq.springcloud.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Luo
 * @date 2021/1/10 14:23
 * @Package com.lq.springcloud.feign
 * class  实现声明式消费者
 */


/**
    标识当前类是 Feign 的客户端
    被标识的类会作为对象存入spring容器中，交给spring容器管理
    引用时通过 @Autowired 注解即可使用
*/
// 定义 Feign 的远程调用时，类似方法的控制器
@FeignClient(name = "04-springcloud-ribbon-eureka-client-provider")
public interface ProviderFeign {

    @RequestMapping("/service/01")
    @LoadBalanced
    public String service01();

}
