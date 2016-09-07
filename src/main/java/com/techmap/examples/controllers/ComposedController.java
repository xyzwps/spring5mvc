package com.techmap.examples.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 组合的 @RequestMapping。
 * 
 * @author Angrynut
 *
 */
@Controller
@RequestMapping("/composed")
public class ComposedController
{
    
    @GetMapping("/get")
    public String get()
    {
        return "/examples/targets/test1";
    }
    
    /**
     * 带有 URI 模板
     */
    @GetMapping(path = "/{day}")
    public String getForDay(@PathVariable @DateTimeFormat(iso = ISO.DATE) Date day, Model model)
    {
        System.out.println("--> " + new SimpleDateFormat("yyyy-MM-dd").format(day));
        
        return "/examples/targets/test2";
    }
    
    @PostMapping("/post")
    public String post(
            @RequestParam(value="username") String user, 
            @RequestParam(value="password") String pass
            )
    {
        System.out.println("--> Username: " + user);
        System.out.println("--> Password: " + pass);
        
        return "/examples/targets/test3";
    }
    
}
