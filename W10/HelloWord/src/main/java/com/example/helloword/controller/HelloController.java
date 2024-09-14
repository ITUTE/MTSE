package com.example.helloword.controller;

import com.example.helloword.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public  String index(){
        return "index";
    }

    @RequestMapping(value="input")
    public String showForm(ModelMap model) {
        model.addAttribute("user", new UserInfo());
        return "HelloInput";
    }
    @RequestMapping(value="hello")
    public String sayHello(@ModelAttribute("user") UserInfo user) {
        return "HelloSuccess";
    }
}