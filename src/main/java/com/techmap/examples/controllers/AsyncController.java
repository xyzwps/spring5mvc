package com.techmap.examples.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
 * <li>在 web.xml 文件的版本应该是3.0</li>
 * <li>在 web.xml 文件的 DispatcherServlet 中开启异步请求处理，并且所有的过滤器也都要开启异步请求</li>
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
     * java.util.concurrent.Callable：上传文件
     * <p/>
     * 下面是 Callable 的介绍（来自 源码）：
     * <p/>
     * 一个返回结果（result）或者抛出异常的任务。实现者定义了一个简单的没有参数的 call 方法。Callable
     * 接口很像 Runnable 接口，它们都被设计为实现类实例都有可能被其他线程执行处理。一个 Runnable，不能
     * 返回一个结果，也不能抛出一个受检异常（checked exception）。
     * The Executors class contains utility methods to convert from other common
     * forms to Callable classes.
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
                 * 处理保存文件的逻辑
                 */
                File f = new File("F:/" + file.getOriginalFilename());
                
                if(!f.exists()) f.createNewFile();
                
                try (FileOutputStream fos = new FileOutputStream(f))
                {
                    InputStream is = file.getInputStream();
                    byte[] bs = new byte[2048];
                    while ((is.read(bs)) != -1)
                        fos.write(bs);
                }
                
                return "/examples/targets/test1";
            }
        };
    }
    
    // TODO DeferredResult
}
