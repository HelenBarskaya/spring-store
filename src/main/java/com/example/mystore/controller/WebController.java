package com.example.mystore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/registration")
    public String registrationPage() {
        return "registration-page";
    }

}
