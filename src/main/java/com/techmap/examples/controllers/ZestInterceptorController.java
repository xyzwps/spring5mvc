package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试拦截器
 * 
 * @author Angrynut
 *
 */
@Controller
@RequestMapping("/test/interceptor")
public class ZestInterceptorController
{
    
    @GetMapping
    public String index()
    {
        return "/examples/targets/test1";
    }
    
    
    @GetMapping("/outOfTime")
    public String outOfTime()
    {
        return "/examples/targets/outOfTime";
    }
    
}
