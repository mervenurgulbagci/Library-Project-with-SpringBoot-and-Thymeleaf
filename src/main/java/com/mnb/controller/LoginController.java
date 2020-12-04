package com.mnb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String redirectHome() {
        return "redirect:/home";
    }
    @RequestMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }
    @RequestMapping("/home")
    public String showMustGoOn(){
        return "home";
    }
    // add request mapping for /access-denied
    @PostMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
