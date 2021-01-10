package com.lq.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @RequestMapping("/01")
    public Object index01() {
        //直接使用restTemplate进行远程访问即可
//        String url = "http://localhost:9200/service/01";
        //将我们的ip地址和端口号换成了服务名称服务名称，UnknowHostException，未知服务、未知的域名
        //需要集成@LoadBalanced注解，这样就可以通过服务名称远程调用某个具体的控制器了

        //在服务注册到注册中心时，是将服务名称和地址进行绑定，我们可以通过服务名称进行远程调用。
        String url = "http://005-springcloud-hystrix-eureka-client-provider/service/01";
        String body = restTemplate.getForObject(url, String.class);
        return body;
    }

    @RequestMapping("/02")
    //fallbackMethod代表遇到异常时，需要执行的熔断方法。
    //返回值和当前方法保持一致
    @HystrixCommand(fallbackMethod = "error")
    public Object index02() {
        String url = "http://005-springcloud-hystrix-eureka-client-provider/service/error";
        String body = restTemplate.getForObject(url, String.class);
        /*
        消费者所报异常：HttpServerErrorException$InternalServerError
        提供者所报异常：500 by zero
        org.springframework.web.client.HttpServerErrorException$InternalServerError:
            500 :
                [
                    {
                        "timestamp":"2021-01-09T02:31:55.679+00:00",
                        "status":500,
                        "error":"Internal Server Error",
                        "message":"",
                        "path":"/service/error"
                    }
                ]
         */
        return body;
    }

    public Object error(Throwable throwable){
        //比如：可以将数据保存到redis中，稍后进行处理
        //或者我们可以采取一个定时任务，专门每个几分钟或多久，扫描redis中的数据，然后进行操作。

        //消息中间件，发送消息到消息队列中，由消息队列进行处理。
        return "hystrix方法熔断处理...";
    }

    //调用服务，由于服务当中引入其他第三方服务，导致无法获取连接，所超时
    @RequestMapping("/03")
    @HystrixCommand(fallbackMethod="timeout", commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1500")})
    public Object index03() {
        String url = "http://005-springcloud-hystrix-eureka-client-provider/service/timeout";
        String body = restTemplate.getForObject(url, String.class);
        return body;
    }

    public Object timeout(Throwable throwable){
//        throwable.get
        return "方法超时，Hystrix返回熔断数据...";
    }

}
