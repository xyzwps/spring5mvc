package com.techmap.examples.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注解 @RestController 是 @Controller 和 @ResponseBody 的结合
 * 
 * 
 * @author Angrynut
 *
 */
@RestController
@RequestMapping("/theRest")
public class TheRestController
{
    
    /**
     * 使用 Map、List、Set 这种类型的返回值时，要在 pom.xml 中加上 Jackson 依赖
     */
    @GetMapping("/find/pet/byId")
    public Map<String, Object> findPet(@RequestParam("petId") int petId)
    {
        System.out.println("--> RestController : Ajax");
        
        Map<String, Object> map = new HashMap<>();
        
        map.put("petName", "Tom");
        map.put("petAge", 1);
        
        return map;
    }
}
