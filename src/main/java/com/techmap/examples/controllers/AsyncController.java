package com.techmap.examples.controllers;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 异步请求处理。
 * <p/>
 * 此示例可以运行的先决条件如下：
 * <ol>
 * <li>在 web.xml 文件的 DispatcherServlet 中开启异步请求处理</li>
 * <li>在上下文配置文件的&lt;mvc:annotation-driven&gt;中开启异步请求处理</li>
 * <li>表单的 enctype 值要设置为 multipart/form-data，用于上传文件</li>
 * <li>要在上下文配置文件中配置 CommonsMultipartResolver 用于解析上传的文件</li>
 * <li>在 pom.xml 文件中添加 commons-fileupload 组件</li>
 * </ol>
 * 
 * @author Angrynut
 *
 */
@RequestMapping("/async")
@Controller
public class AsyncController
{
    /**
     * TODO 上传文件
     */
    @PostMapping("/fileupload/callable")
    public Callable<String> processUpload(@RequestParam("file") final MultipartFile file, @RequestParam("name") String name)
    {
        return new Callable<String>()
        {
            public String call() throws Exception
            {
                System.out.println("--> Name : " + name);
                System.out.println("--> File name ： " + file.getOriginalFilename());
                
                /**
                 * 处理保存文件的逻辑【潇洒的省略】
                 */
                
                return "/examples/targets/test1";
            }
        };
    }
    
}
