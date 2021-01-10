package com.lq.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Luo
 * @date 2021/1/10 16:54
 * @Package com.lq.springcloud.feign
 * class
 */
//表示当前类是 Feign 的客户端
@SuppressWarnings("ALL")
@FeignClient(name = "006-springcloud-feign-provider")
public interface ProviderFeign {

    //在消费者中，远程调用提供者的方法
    /*
    提供者是没有一级路径的
    @RequestMapping("/helloSpringCloud")
    public String helloSpringCloud(){
        return "helloSpringCloud";
    }
    */
    //http://006-springcloud-feign-provider/helloSpringCloud
    @RequestMapping("/helloSpringCloud")
    public String helloSpringCloud();


    /*
    @GetMapping("/get02/{id}")
    public String helloSpringCloud(@PathVariable String id)\

    没有添加@PathVariable注解会出现404异常：
        由于当前传递的参数无法映射到请求的路径当中
    [http://006-springcloud-feign-provider/get02/]
        如果当前@PathVariable注解中的参数名称必须和{id}参数名称一致
     */
    @GetMapping("/get02/{id}")
    public String helloSpringCloud02(@PathVariable(name = "id") String userId);

    /*
    如果传递的参数出现到形参中，就代表着要封装到请求体当中
    接收方法的控制器，就可以通过@RequestBody获取数据
    @PostMapping("/post03")
    public String post03(@RequestBody String username)
     */
    @PostMapping("/post03")
    public String post03(String username);

    /*
    @PutMapping("/put04")
    public Object put04(@RequestBody Map map)
     */
    @PutMapping("/put04")
    public Object put04(Map map);

    /*
    @DeleteMapping("/delete05/{id}")
    public Object put04(@PathVariable String id)
    返回object类型，会遭遇ContentType类型问题

    public String delete05(@PathVariable String id);
    指定默认类型是json请求和返回，如果指定Object类型会返回text文本类型
     */
    @DeleteMapping(value = "/delete05/{id}")
    public String delete05(@PathVariable String id);

}
