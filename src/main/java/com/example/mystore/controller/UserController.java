package com.example.mystore.controller;

import com.example.mystore.model.User;
import com.example.mystore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/registration")
    public String registration(@RequestParam(value = "username") String username,
                               @RequestParam(value = "firstname") String firstname,
                               @RequestParam(value = "lastname") String lastname,
                               @RequestParam(value = "adress") String adress,
                               @RequestParam(value = "password") String password) {
        userService.saveUser(new User(username, password, firstname, lastname, adress, "ROLE_USER"));
        return "index";
    }
}
