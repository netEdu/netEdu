package com.netEdu.utils.netty;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component  
public class CorsFilter implements Filter {  
  
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);  
  
  
  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Allow-Headers","Authorization,Origin,X-Requested-With,X-File-Name,Content-Type, Accept");
        System.out.println("*********************************过滤器被使用**************************");  
        chain.doFilter(req, res);
    }  
    public void init(FilterConfig filterConfig) {}  
    public void destroy() {}  
}  
