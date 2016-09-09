package com.techmap.examples.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/uritpl")
public class URITemplateController
{

    @GetMapping("findPet/owners/{ownerId}/pets/{petId}")
    public String findPet(
            @PathVariable(value = "ownerId") String ownerId,
            @PathVariable(value = "petId") String petId) 
    {
        
        System.out.println("--> ownerId : " + ownerId);
        System.out.println("--> petId : " + petId);
        
        return "/examples/targets/test2";
    }
    
    @GetMapping(value = "/get/owners/{ownerId}/pets/{petId}")
    public String getMap(@PathVariable Map<String, String> kv)
    {
        
        System.out.println("-->" + kv.toString());
        
        return "/examples/targets/test2";
    }
    
    /**
     * 当在一个Map<String, String>参数上使用@PathVariable注解时，这个Map会被填上所有的URI模板变量。
     */
    @GetMapping(value = "/regex/file/{fileName:[_a-zA-Z0-9]+}{extension:\\.[a-z]+}")
    public String regex(
            @PathVariable("fileName") String fileName, 
            @PathVariable("extension") String extension)
    {
        
        System.out.println("--> Full File Name : " + fileName + extension);
        
        return "/examples/targets/test3";
    }
}
