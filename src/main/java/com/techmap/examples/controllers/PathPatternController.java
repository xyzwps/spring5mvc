package com.techmap.examples.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pathpattern")
public class PathPatternController
{
   
    /**
     * 对于请求 "pathpattern/findPet/Jennifer/Jennifer_1234/pets/pdog_2134" 根据匹配规则，会执行 findPet() 方法；
     * 对于请求 "pathpattern/findPet/manager/admin/pets/pdog_0001" 根据匹配规则，匹配通配符最少的那个，会执行 findNFRPet() 方法。
     */
    
    
    
    @GetMapping("findPet/*/{ownerId}/pets/{petId}")
    public String findPet(
            @PathVariable(value = "ownerId") String ownerId,
            @PathVariable(value = "petId") String petId) 
    {
     
        System.out.println("--> ------ findPet ------");
        System.out.println("--> ownerId : " + ownerId);
        System.out.println("--> petId : " + petId);
        
        return "/examples/targets/test1";
    }
    
    
    @GetMapping(value = "/findPet/manager/{ownerId}/pets/{petId}")
    public String findNFRPet(
            @PathVariable(value = "ownerId") String ownerId,
            @PathVariable(value = "petId") String petId) 
    {
        System.out.println("--> ------ findNFRPet ------");
        System.out.println("--> ownerId : " + ownerId);
        System.out.println("--> petId : " + petId);
        
        return "/examples/targets/test2";
    }
}
