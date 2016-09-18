package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用矩阵变量，需要在 mvc 注解驱动里开启矩阵变量的使用
 * 
 * @author Angrynut
 */
@Controller
@RequestMapping("/matrix")
public class MatrixController
{
    
    /**
     * 使用矩阵变量
     */
    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public String findPet(@PathVariable String ownerId, @PathVariable String petId, @MatrixVariable(name = "q",
        pathVar = "ownerId") int q1, @MatrixVariable(name = "q", pathVar = "petId") int q2)
    {
        System.out.println("--> ownerId : " + ownerId);
        System.out.println("--> petId : " + petId);
        System.out.println("--> q1 : " + q1);
        System.out.println("--> q2 : " + q2);
        
        return "/examples/targets/test1";
    }
    
    /**
     * 矩阵变量可以设置默认值
     */
    @GetMapping("/pets/{petId}")
    public String findPet(@MatrixVariable(required = false, defaultValue = "1") int q)
    {
        System.out.println("--> Default value of q : " + q);
        
        return "/examples/targets/test2";
    }
    
}
