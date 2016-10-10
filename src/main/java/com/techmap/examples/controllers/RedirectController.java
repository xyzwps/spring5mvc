package com.techmap.examples.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
     * 使用重定向视图。
     * 
     * <p/>
     * 
     * 如果项目部署在 Web 容器（如 Tomcat）的根目录下，RedirectView 的构造器的第一个参数是不用添加上下文路径的；
     * 否则，要添加。因为重定向结果是 http://ip:port/{uri}（这里的 uri 就是 RedirectView 构造的的第一个参数）。
     * 
     * <p/>
     * 
     * 关于在 Eclipse 下如何把项目部署到 Tomcat 的根目录下，请看
     * <a href="http://hyj0903.blog.163.com/blog/static/309065522014999496306/">这里</a>
     */
    @GetMapping("/get/pet/{petName}")
    public ModelAndView getPet(HttpServletRequest request, @PathVariable("petName") String petName, final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();
        
        log.info("\n\t--> Pet Name : " + petName);
        log.info("\n\t--> Servlet Path : " + request.getServletPath());
        log.info("\n\t--> Context Path : " + request.getContextPath());
        
        RedirectView rv = new RedirectView(decorateContextPath(request.getContextPath()) + "/redict/target", false);
        
        redirectAttributes.addAttribute("sth", petName);
        redirectAttributes.addFlashAttribute("sth", "Pet Name : " + petName);
        
        mav.setView(rv);
        
        return mav;
    }
    
    /**
     * 使用重定向前缀
     */
    @GetMapping("/get/owner/{ownerId}")
    public String getOwner(@PathVariable("ownerId") int id, final RedirectAttributes redirectAttributes)
    {
        log.debug("\n\t--> Owner ID : " + id);
        
        redirectAttributes.addAttribute("sth", id);
        redirectAttributes.addFlashAttribute("sth", "Owner ID : " + id);
        
        return "redirect:/redict/target";
    }
    
    @GetMapping("/target")
    public String target()
    {
        return "/examples/targets/test4";
    }
    
    /**
     * 修饰上下文路径
     */
    private String decorateContextPath(String cp)
    {
        if(cp == null || cp.equals("/")) return "";
        else return cp;
    }
}
