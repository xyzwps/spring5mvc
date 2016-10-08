package com.techmap.examples.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 测试重定向
 * 
 * @author Angrynut
 *
 */
@Controller
@RequestMapping("/redict")
public class RedirectController
{
    private static final Logger log = Logger.getLogger(RedirectController.class);
    
    /**
     * 使用重定向视图
     * <p/>
     * 不知道为什么，在<a href="http://hyj0903.blog.163.com/blog/static/309065522014999496306/">
     * 把项目部署到 Tomcat 的根目录下</a>，重定向视图才正确跳转
     */
    @GetMapping("/get/pet/{petName}")
    public ModelAndView getPet(@PathVariable("petName") String petName)
    {
        ModelAndView mav = new ModelAndView();
        
        log.debug("\n\t--> Pet Name : " + petName);
        
        mav.addObject("sth", petName);
        
        RedirectView rv = new RedirectView("/redict/target", false);
        
        mav.setView(rv);
        
        return mav;
    }
    
    /**
     * 使用重定向前缀
     */
    @GetMapping("/get/owner/{ownerId}")
    public String getOwner(@PathVariable("ownerId") int id)
    {
        log.debug("\n\t--> Owner ID : " + id);
        
        return "redirect:/redict/target";
    }
    
    @GetMapping("/target")
    public String target()
    {
        return "/examples/targets/test4";
    }
}
