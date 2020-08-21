package com.zz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {

    @GetMapping("/e/t")
    public String test1(String name, Model model){
        model.addAttribute("msg",name);
        return "test";

    }
}
