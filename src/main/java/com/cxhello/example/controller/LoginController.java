package com.cxhello.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cxhello
 * @date 2021/4/25
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
