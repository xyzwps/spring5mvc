package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个控制器与 MyControllerAdvice 配合
 * 
 * @author Angrynut
 */
@Controller
@RequestMapping("/myCtrl")
public class MyController
{
    
    @GetMapping
    public String test()
    {
        return "/examples/targets/test1";
    }
    
}
