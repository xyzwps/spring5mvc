package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 构建 URI
 * 
 * @author Angrynut
 *
 */
@RequestMapping("/buildUri/country/{country}")
@Controller
public class BuildURIController
{
    
    @RequestMapping("/city/{city}/street/{street}")
    public String getAddress(
            @PathVariable("city") String city,
            @PathVariable("street") String street, 
            Model model) 
    { 
        model.addAttribute("sth", city + " St. " +  street);
        
        return "/examples/targets/test1";
    }
}
