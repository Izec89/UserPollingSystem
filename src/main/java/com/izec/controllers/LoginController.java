package com.izec.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/log")
public class LoginController {

    @GetMapping
    public String login() {
        return "redirect:login";
    }

    @PostMapping
    public String enterAsGuest(Model model, @RequestParam String name, @RequestParam String password) {
        model.addAttribute("username", name);
        model.addAttribute("password", password);
        return "redirect:login";
    }

}

