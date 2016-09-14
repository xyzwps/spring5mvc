package com.techmap.examples.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/respBody")
public class RespBodyController
{
    
    @GetMapping("/find/pet")
    @ResponseBody
    public String findPet()
    {
        System.out.println("--> ResponseBody : Ajax");
        
        return "This is errr...";
    }
    
    
    /**
     * 使用 Map、List 这种类型的返回值时，要在 pom.xml 中加上 Jackson 依赖
     */
    @GetMapping("/find/pet/byId")
    @ResponseBody
    public Map<String, Object> findPet(@RequestParam("petId") int petId)
    {
        System.out.println("--> ResponseBody : Ajax");
        
        Map<String, Object> map = new HashMap<>();
        
        map.put("petName", "Tom");
        map.put("petAge", 1);
        
        return map;
    }
}
