package org.gerry.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DemoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(" pre Interceptor ");
        String url = httpServletRequest.getRequestURI();
        if(o instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod)o;
            System.out.println(" Interceptor url :"+method.getBean().getClass().getName());
            System.out.println(" Interceptor Method name :"+method.getMethod().getName());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if(null != modelAndView){
            Map<String,Object> map = modelAndView.getModel();
            map.put("postHandle","true");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
