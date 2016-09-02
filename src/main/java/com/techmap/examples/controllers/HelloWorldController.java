package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController
{
    
    @RequestMapping("/helloWorld")
    public String helloWorld(Model model)
    {
        System.out.println("-> Hello World!");
        
        model.addAttribute("message", "Hello World!");
        return "/examples/helloWorld";
    }
}
