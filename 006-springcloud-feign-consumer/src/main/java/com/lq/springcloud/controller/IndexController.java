package com.lq.springcloud.controller;

import com.lq.springcloud.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luo
 * @date 2021/1/10 16:58
 * @Package com.lq.springcloud.controller
 * class
 */

@RestController
public class IndexController {

    //    @Autowired
//    RestTemplate restTemplate;//在引导类中初始化

    @Autowired
    private ProviderFeign providerFeign;

    @RequestMapping("/index01")
    public String index01(){
        String body = providerFeign.helloSpringCloud();
        return body;
//        return null;
    }

    @RequestMapping("/index02")
    public String index02(){
        String body = providerFeign.helloSpringCloud02("123");
        return body;
    }

    @RequestMapping("/index03")
    public String index03(){
        String body = providerFeign.post03("zhangsan");
        return body;
    }

    @RequestMapping("/index04")
    public Object index04(){
        Map<String,Object> map = new HashMap<>();
        map.put("id","123");
        map.put("name","lisi");

        /*
            使用restTemplate方法的put和delete方法，是没有返回值的
            即使提供者工程，有返回的结果，也无法正常获取到
            如果换成Feign进行远程调用，这种局限性就不存在了
         */
        Object object = providerFeign.put04(map);
        return object;
    }


    //feign会将delete方式请求的返回值为object类型视为文本类型
    //1.可以替换掉feign原本的解析器
    //2.将返回值改成string类型接收
    //删除动作，只会返回一个标记，代表是否删除成功
    @RequestMapping("/index05")
    public Object index05(){
        String object = providerFeign.delete05("222");
        return object;
    }


}
