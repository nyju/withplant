package com.withplant.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainConfig{

    @GetMapping("/")
    public String home(Model model){
        System.out.println("Index");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
