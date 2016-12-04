package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cihanblt
 */
@Controller
@RequestMapping
public class LoginController {

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    private String login(){
        return "login";
    }

    @RequestMapping(path = "/signup",method = RequestMethod.GET)
    private String signup(){
        return "signup";
    }

    @RequestMapping(path = "/error",method = RequestMethod.GET)
    private String error(){
        return "error";
    }

}
