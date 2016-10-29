package com.techmap.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用于测试文件上传的控制器
 * 
 * @author Angrynut
 *
 */
@Controller
@RequestMapping("/test/multipart")
public class ZestMultipartController
{
    @PostMapping("/commons/fileupload")
    public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) 
    {
        if (!file.isEmpty()) 
        {
            // byte[] bytes = file.getBytes();
            System.out.println("--> 上传的文件的名称：" + file.getName());
            // store the bytes somewhere
            return "/examples/targets/test1";
        }
        return "/examples/targets/test2";
    }

    
}
