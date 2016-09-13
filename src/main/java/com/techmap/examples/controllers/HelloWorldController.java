package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/helloWorld/jump")
    public String jump(@RequestParam("jsp") String jsp)
    {
        return "/examples/" + jsp;
    }
}
