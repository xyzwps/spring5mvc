package com.techmap.examples.controllerAdvices;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.techmap.examples.controllers.MyController;

/**
 * 通知控制器：指向包 com.techmap.examples.controllers 中的控制器。
 * <p/>
 * 带有@ControllerAdvice注解的类可以包含带有@ExceptionHandler、@InitBinder和@ModelAttribute注解的方法
 * <p/>
 * 需要配置：
 * &lt;context:component-scan
 * base-package="com.techmap.examples.controllerAdvices" /&gt;
 */
@ControllerAdvice(assignableTypes = { MyController.class })
public class MyControllerAdvice
{
    
    @ModelAttribute
    public void modelAttr(Model model)
    {
        model.addAttribute("sth", "--> @ControllerAdvice");
    }
}
