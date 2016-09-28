package com.techmap.examples.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 这是一个 Spring 拦截器。除了继承 HandlerInterceptorAdapter 这种方式之外，也可以实现
 * 接口 HandlerInterceptor 和 AsyncHandlerInterceptor。
 * <p/>
 * HandlerInterceptor 接口定义了三个方法：
 * <ol>
 * <li>preHandle(..) 在处理方法执行前调用；</li>
 * <li>postHandle(..) 在处理方法执行后调用；</li>
 * <li>afterCompletion(..) 在完成请求结束后调用。</li>
 * </ol>
 * 这三个方法为预处理和后处理提供了足够的灵活性。
 * <p/>
 * 这里把它配置在了 &lt;mvc:interceptors/&gt; 中
 * 
 * @author Angrynut
 *
 */
public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter
{
    private static Logger log = Logger.getLogger(TimeBasedAccessInterceptor.class);
    
    private int openingTime;
    private int closingTime;
    
    public void setOpeningTime(int openingTime)
    {
        this.openingTime = openingTime;
    }
    
    public void setClosingTime(int closingTime)
    {
        this.closingTime = closingTime;
    }
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        log.debug("------> 执行了预处理方法");
        
        String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request
                .getServerPort() + request.getContextPath() + "/";
        
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if(openingTime <= hour && hour < closingTime) return true;
        response.sendRedirect(basepath + "test/interceptor/outOfTime");
        return false;
    }
}
