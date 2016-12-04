package com.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * Created by cihanblt
 */
@Controller
@RequestMapping
public class HomeController {

    @RequestMapping(path = "/")
    public String goToIndex(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        System.out.println("index page");
        System.out.println("testtttt");
        System.out.println("testtttt22");
//        System.out.println(5/0);
        return "index";
    }


}
