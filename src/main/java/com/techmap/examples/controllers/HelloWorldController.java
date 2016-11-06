package com.techmap.examples.controllers;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController
{
    
    @GetMapping("/hw")
    public String helloWorld() 
    {
        return "/index";
    }
    
    
    @PostMapping("/upload")
    public String upload(@RequestParam("name") String name, @RequestParam("file") Part file, Model model) 
    {
//        InputStream inputStream = file.getInputStream();
        
        System.out.println("--> File Name: " + file.getSubmittedFileName());
        
        model.addAttribute("data", "Success!");
        
        return "/result";
    }
}
