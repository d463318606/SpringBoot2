package com.atguigu.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
//登录检查
public class LoginInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("prehandle拦截的路径是"+requestURI);
        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            //放行
            return true;
        }
        //拦截住，未登录。跳转到登录页
        request.setAttribute("msg","请先登录");
        //response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);
        return  false;
    }

    //目标方法执行之后

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    log.info("posthandle执行"+modelAndView);
    }

    //页面渲染以后

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
