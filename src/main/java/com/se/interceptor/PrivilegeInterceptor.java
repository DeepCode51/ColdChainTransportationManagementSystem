package com.se.interceptor;

import com.se.domain.Users;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author baoweiwei
 * @data 2021/10/21 - 21:41
 */
public class PrivilegeInterceptor implements HandlerInterceptor {
    /**
     * 实现登录拦截功能的拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //逻辑 判断用户是否登录  本质，判断session中有没有user对象
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("users");
        if (users == null) {
            //没有登录
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        // 放行 访问目标资源
        return true;
    }
}
