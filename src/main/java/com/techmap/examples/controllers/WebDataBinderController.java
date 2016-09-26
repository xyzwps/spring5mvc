package com.techmap.examples.controllers;

import java.util.Date;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/webDataBinder")
public class WebDataBinderController
{
    /**
     * 用@InitBinder注解的控制器方法，允许你直接在你的控制器类中配置Web数据绑定。
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
    
    @RequestMapping("/ib/date/{date}")
    public ModelAndView ib(@PathVariable("date") Date d)
    {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("sth", d);
        mav.setViewName("/examples/targets/test1");
        
        return mav;
    }
    
}
