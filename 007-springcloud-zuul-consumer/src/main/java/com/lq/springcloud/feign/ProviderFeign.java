package com.lq.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:ProviderFeign
 * PackageName:com.bjpowernode.springcloud.feign
 * Description:
 *
 * @date 2021/1/9 15:07
 * @author: 动力节点
 */
@FeignClient(name = "007-springcloud-zuul-provider")
public interface ProviderFeign {

    /*
    @RequestMapping("/service")
    +
    @RequestMapping("/01")
    public Object service01()
     */
    @RequestMapping("/service/01")
    public String service01();

}
