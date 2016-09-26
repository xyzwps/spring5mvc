package com.techmap.examples.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jsonp")
public class JsonpController
{
    
    @GetMapping
    @ResponseBody
    public Map<String, Object> getJsonp()
    {
        
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("type", "cat");
        
        return map;
    }
    
}
