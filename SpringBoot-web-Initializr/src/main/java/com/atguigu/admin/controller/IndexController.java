package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
//来登录页面
public class IndexController {
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())) {
            //把登录成功的用户保存到session中
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html,重定向可以防止表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        log.info("当前方式是"+"mainpage");
       /* //是否登录（拦截器-过滤器）
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新输入");
            return "login";
        }
    */
        return "main";
    }
}

