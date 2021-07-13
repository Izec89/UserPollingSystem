package com.izec.controllers;


import com.izec.domeins.User;
import com.izec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registrationUser";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {

        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registrationUser";
        }


        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "User successful activated");
        } else {
            model.addAttribute("message", "Activation code is not found");
        }

        return "login";
    }

    @PostMapping("/registration/guest")
    public String addUserAsGuest(Model model) {
        User guest = new User();
        guest.setName("guest" + userService.getLastId());
        guest.setEmail("some@some.com");
        guest.setPassword("password");
        model.addAttribute("usrname", guest.getName());
        model.addAttribute("pass", guest.getPassword());
        userService.addUserAsGuest(guest);
        return "redirect:/main";
    }


}

