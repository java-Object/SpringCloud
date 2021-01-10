package com.lq.springcloud.controller;

import com.lq.springcloud.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:IndexController
 * PackageName:com.bjpowernode.springcloud.controller
 * Description:
 *
 * @date 2021/1/8 14:56
 * @author: 动力节点
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private ProviderFeign providerFeign;

    @RequestMapping("/01")
    public Object index01(){
        //直接使用restTemplate进行远程访问即可
//        String url = "http://localhost:9200/service/01";
        //将我们的ip地址和端口号换成了服务名称服务名称，UnknowHostException，未知服务、未知的域名
        //需要集成@LoadBalanced注解，这样就可以通过服务名称远程调用某个具体的控制器了

        //在服务注册到注册中心时，是将服务名称和地址进行绑定，我们可以通过服务名称进行远程调用。
        Object body = providerFeign.service01();
        return body;
    }

}
