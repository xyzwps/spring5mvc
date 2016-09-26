package com.techmap.examples.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cookieAndHeader")
public class CookieAndHeaderController
{
    
    /**
     * 使用@CookieValue获取cookie值
     */
    @RequestMapping("/jSessionId")
    public String cookie(@CookieValue("JSESSIONID") String jSessionId, Model model)
    {
        model.addAttribute("sth", jSessionId);
        return "/examples/targets/test1";
    }
    
    /**
     * 获取请求头的值
     */
    @RequestMapping("/reqHeader")
    public ModelAndView reqHeader(
            @RequestHeader("Accept-Encoding") String encoding, 
            @RequestHeader("Accept") List<String> accept)
    {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("sth", "Accept-Encoding: " + encoding + "; Accept: " + accept);
        mav.setViewName("/examples/targets/test1");
        
        return mav;
    }
}
