package com.techmap.examples.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "myFilter", description = "测试过滤器", urlPatterns = { "/sesAndReqAttr/reqAttr" })
public class MyFilter implements Filter
{
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println("--> MyFilter Do.");
        request.setAttribute("reqStr", "万万没想到，啦啦啦啦啦！");
        
        chain.doFilter(request, response);
        
    }
    
    @Override
    public void destroy()
    {}
    
}
