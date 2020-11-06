package com.sunday.springboot.interceptor1;

import com.sunday.springboot.Service.TestService;
import com.sunday.springboot.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    TestService testService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        String token=request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return  true;
        }
        if (token!=null){
            String name = JwtUtil.getUserNameByToken(request);
            boolean result =JwtUtil.verify(token,name, testService.getPassword(name));
            if(result){
                System.out.println("通过拦截器");
                return true;
            }else {
                System.out.println("未通过拦截");
                return false;
            }
        }
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
