package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * <ol>
 * <li>要有一个 XlsView 类</li>
 * <li>配置一个 Xml 视图解析器，这个视图解析器指向一个 Spring Bean 定义的 XML 文件（本例中是 mvc-views.xml）</li>
 * <li>在 mvc-views.xml 中，配置一个 XlsView 类型的 Bean（本例中，这个 Bean 的 id 是 xlsview）</li>
 * <li>控制器返回 "xlsview"，即可得到 xls 格式的 Excel 文件</li>
 * </ol>
 * @author Angrynut
 *
 */
@Controller
@RequestMapping("/excel/view")
public class VestXlsViewController
{
    
    @GetMapping("/xls")
    public String getXls()
    {
        return "xlsview"; 
    }
    
}
