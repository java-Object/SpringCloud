package com.lq.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:MyZuulFilter
 * PackageName:com.bjpowernode.springcloud.filter
 * Description:
 *
 * @date 2021/1/9 15:44
 * @author: 动力节点
 */
@Component
public class MyZuulFilter extends ZuulFilter {


    //过滤器类型，pre代表前置过滤器
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器优先级 ，数字越小，优先级越高
    @Override
    public int filterOrder() {
        return 1;
    }

    //是否启用过滤器，false代表不启用。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //规律规则
    @Override
    public Object run() throws ZuulException {

        System.out.println("MyZuulFilter拦截执行...");

        //获取当前请求的上下文对象
        RequestContext requestContext=RequestContext.getCurrentContext();
        //获取当前请求对象
        HttpServletRequest request=requestContext.getRequest();
        //获取请求参数中的token数据（用户的身份令牌）
        String token=request.getParameter("token");
        if(token==null){//进入if表示当前请求中没有携带token我们任务当前请求是非法请求
            //通知ZuulAPI网关当前请求非法
            requestContext.setSendZuulResponse(false);
            //设置响应编码为401 表示权限不足
            requestContext.setResponseStatusCode(401);
            //设置响应的头文件信息以html或文本响应编码格式为utf-8
            requestContext.addZuulResponseHeader("content-type","text/html;charset=utf-8");

            //设置响应的内容
            requestContext.setResponseBody("非法访问");
        }else{
            System.out.println("用户携带了身份令牌需要验证这个身份是否真的合法");

        }
        return null;
    }
}
