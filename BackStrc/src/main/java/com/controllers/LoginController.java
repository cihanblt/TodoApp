package com.controllers;

import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by cihanblt
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    private String login() {
        return "login";
    }

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    private String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    private String error() {
        return "error";
    }

    @RequestMapping(path = "/add_user", method = RequestMethod.POST)
    private String addUser(@ModelAttribute(value = "user") User user, Model model, RedirectAttributes redirectAttributes) {
        User user1 = new User();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setUserName(user.getUserName());
        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
        user1.setPassword(shaPasswordEncoder.encodePassword(user.getPassword(), null));
        if (userService.saveUser(user1)){
            redirectAttributes.addFlashAttribute("success", true);
        }else {
            redirectAttributes.addFlashAttribute("success", false);
        }
        return "redirect:/signup";
    }

}
