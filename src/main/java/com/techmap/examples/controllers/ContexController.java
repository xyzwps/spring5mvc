package com.techmap.examples.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/contex")
public class ContexController
{
    
    /**
     * 不指定 path 参数
     */
    @RequestMapping(method = RequestMethod.GET)
    public String get1()
    {
        return "/examples/targets/test1";
    }
    
    /**
     * 带有 path 参数
     */
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String get2()
    {
        return "/examples/targets/test2";
    }
    
    /**
     * 带有 URI 模板
     */
    @RequestMapping(path = "/{day}", method = RequestMethod.GET)
    public String getForDay(@PathVariable @DateTimeFormat(iso = ISO.DATE) Date day, Model model)
    {
        System.out.println("--> " + new SimpleDateFormat("yyyy-MM-dd").format(day));
        
        return "/examples/targets/test3";
    }
}
