package com.techmap.examples.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HttpEntity
 * 
 * @author Angrynut
 */
@Controller
@RequestMapping("/httpEntity")
public class HttpEntityController
{
    
    @PostMapping("/something")
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException
    {
        String requestHeader = requestEntity.getHeaders().getFirst("Host");
        byte[] requestBody = requestEntity.getBody();
        
        // 用请求头和请求体做一些事
        System.out.println("-->" + requestHeader);
        System.out.println("-->" + new String(requestBody));
        
        // 发送请求
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }
}
