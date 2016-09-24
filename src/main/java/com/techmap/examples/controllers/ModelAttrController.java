package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techmap.examples.entities.Pet;

/**
 * 注解 @ModelAttribute。
 * <p/>
 * 带有此注解的方法会在控制器处理方法之前调用。
 * 
 * @author Angrynut
 */
@Controller
@RequestMapping("/modelAttr")
public class ModelAttrController
{
    /**
     * UNCLEAR 多个 @ModelAttribute 方法先运行哪一个？
     */
    @ModelAttribute(value = "petId")
    public Pet getPet(int petId)
    {
        System.out.println("--> @ModelAttribute getPet : petId = " + petId);
        return new Pet().setPetId(petId).setPetName("Baltan").setPetType("alien");
    }
    
    @ModelAttribute
    public void getSomethingElse(@RequestParam("sth") String sth, Model model)
    {
        System.out.println("--> @ModelAttribute getSomethingElse : sth = " + sth);
        model.addAttribute("sth", sth);
    }
    
    @GetMapping("/findPet/owner/{ownerId}")
    public String findPet(@PathVariable(value = "ownerId") String ownerId, Model model)
    {
        
        System.out.println("--> ownerId : " + ownerId);
        System.out.println("--> pet : " + model.asMap());
        
        return "/examples/targets/test1";
    }
}
