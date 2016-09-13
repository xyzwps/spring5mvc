package com.techmap.examples.controllers;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paramAndBody")
public class ParamAndBodyController
{
    
    /**
     * 使用 @RequestParam 时，请求参数名要和 @RequestParam 的值一样，而不是和方法参数名一样
     */
    @GetMapping("/find/pet")
    public String findPet(@RequestParam("petId") int pid, ModelMap model) 
    {
        System.out.println("--> petId : " + pid);
        
        /**
         * 将被放到响应中，发送到客户端
         */
        model.addAttribute("test", "Hello World - @RequestParam(\"petId\") int pid");
        
        return "/examples/targets/test4";
    }
    
    /**
     * 使用 @RequestParam 时，请求参数名要和 @RequestParam 的值一样，而不是和方法参数名一样
     */
    @GetMapping("/find/pet/map")
    public String findPet(@RequestParam Map<String, String> map, ModelMap model) 
    {
        System.out.println("--> Map : " + map.toString());
        System.out.println("--> petId : " + map.get("petId"));
        
        /**
         * 将被放到响应中，发送到客户端
         */
        model.addAttribute("test", "Hello World - @RequestParam Map<String, String> map");
        
        return "/examples/targets/test4";
    }
    
    
    /**
     * 带有 @RequestBody 注解的参数，直接可以得到请求体
     */
    @PutMapping("/handle")
    public void handle(@RequestBody String body, Writer writer) throws IOException 
    {
        System.out.println("--> body : " + body);
        
        /**
         * 将被放到响应中，发送到客户端
         */
        writer.write("{ pet :" + body + " }");
    }

    

}
