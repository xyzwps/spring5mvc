package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/redict")
public class RedirectController
{
 
    /**
     * 使用重定向视图
     */
    @GetMapping("/get/pet/{petName}")
    public ModelAndView getPet(@PathVariable("petName") String petName)
    {
        ModelAndView mav = new ModelAndView();
        
        System.out.println("\t--> Pet Name : " + petName);
        
        mav.addObject("sth", petName);
        
        RedirectView rv = new RedirectView("/redict/target", false);
        
        mav.setView(rv);
        
        return mav;
    }
    
    
    
    
    
    @GetMapping("/target")
    public String target()
    {
        return "/examples/targets/test4";
    }
}
