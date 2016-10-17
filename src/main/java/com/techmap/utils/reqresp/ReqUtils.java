package com.techmap.utils.reqresp;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求处理工具
 * 
 * @author Angrynut
 *
 */
public class ReqUtils
{
    
    private ReqUtils()
    {
        throw new RuntimeException("Can not get the util instance.");
    }
    
    /**
     * 假定主机号为 www.example.com， 端口为 port。
     * 如果端口为 80，返回 www.example.com，否则返回 www.example.com:port
     */
    public static String getHost(HttpServletRequest req)
    {
        if(req == null) return null;
        
        if(req.getServerPort() == 80) return req.getServerName();
        
        return req.getServerName() + ":" + req.getServerPort();
    }
    
}
