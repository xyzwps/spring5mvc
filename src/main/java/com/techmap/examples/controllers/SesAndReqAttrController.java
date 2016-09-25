package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/sesAndReqAttr")
public class SesAndReqAttrController
{
    /**
     * 在处理请求 /helloWorld/jump 的时候，会在会话中添加一个 sessionStr 属性。
     * <p/>
     * 这里可以通过@SessionAttribute 获取到
     */
    @RequestMapping("/sesAttr")
    public String handleSessionAttr(@SessionAttribute(value = "sessionStr") String sessionStr, Model model)
    {
        System.out.println("--> sessionStr : " + sessionStr);
        model.addAttribute("sth", sessionStr);
        return "/examples/targets/test1";
    }
    
    /**
     * 注解@RequestAttribute可以被用于访问由过滤器或拦截器创建的、预先存在的请求属性：
     */
    @RequestMapping("/reqAttr")
    public String handle(@RequestAttribute("reqStr") String str, Model model)
    {
        System.out.println("--> reqStr : " + str);
        model.addAttribute("sth", str);
        return "/examples/targets/test1";
    }
    
}
