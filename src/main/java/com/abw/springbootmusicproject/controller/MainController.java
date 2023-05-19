package com.abw.springbootmusicproject.controller;

import com.abw.springbootmusicproject.security.DefaultUserDetailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private DefaultUserDetailService defaultUserDetailService;

    @GetMapping(value = "/")
    public String getIndex(ModelMap model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
