package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techmap.examples.entities.Pet;

/**
 * 用在方法参数上的@ModelAttribute。
 * <p/>
 * 获取@ModelAttribute参数值能通过一下途径：
 * <ol>
 * <li>它可能已经存在与模型中了，因为使用了@SessionAttributes</li>
 * <li>它可能已经存在于模型中了，因为同一个控制器中的@ModelAttribute方法，就像上一节中解释的那样。</li>
 * <li>它可能是从URI模板变量和类型转换器中获取的（下面会详细解释）。</li>
 * <li>它可能是使用默认构造器初始化的。</li>
 * </ol>
 * 至于，上述获取参数值的途径中，至少有两个可以获取参数值，且参数值不同，参数值的获取策略不清楚。
 * 不过可以通过实验来确定。这里不做这个实验。
 * 
 * @author Angrynut
 */
@Controller
@RequestMapping("/modelAttrArgs")
public class ModelAttrArgsController
{
    /**
     * 这个处理方法中的 @ModelAttribute 参数 pet 是从 URI 模板变量中获取的。获取之后，pet 对象会被自动放到 Model
     * 中。
     */
    @GetMapping("/save/ownerId/{ownerId}/petId/{petId}")
    public String savePet(@ModelAttribute Pet pet)
    {
        System.out.println("--> Pet : " + pet);
        return "/examples/targets/test1";
    }
    
    /**
     * 这里注册了一个从 json 字符串到 Pet 对象的类型转换器（JsonStrToPetConverter.java）。
     */
    @GetMapping("/edit/pet/{pet}")
    public String editPet(@ModelAttribute("pet") Pet p)
    {
        System.out.println("--> Pet : " + p);
        return "/examples/targets/test1";
    }
    
    /**
     * 
     */
    @GetMapping("/set/pet/age/{age}")
    public String setPetAge(@ModelAttribute(value = "age", binding = false) int p)
    {
        System.out.println("--> Pet Age : " + p);
        return "/examples/targets/test1";
    }
    
}
