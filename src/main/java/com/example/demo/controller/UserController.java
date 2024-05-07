package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.model.RequestResponse;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    @PostMapping("/register")

    public RequestResponse savedata(@RequestBody UserModel userModel) {
        RequestResponse res = uService.savedata(userModel);
        return res;

    }

    @PostMapping("/login")
    public RequestResponse loginUser(@RequestBody LoginModel loginModel) {
        RequestResponse res = uService.logindata(loginModel);
        return res;
    }

}
