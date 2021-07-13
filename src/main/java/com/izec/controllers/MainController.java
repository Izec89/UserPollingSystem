package com.izec.controllers;


import com.izec.domeins.Poll;
import com.izec.domeins.User;
import com.izec.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private PollRepository pollRepository;

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Poll> polls = pollRepository.findAll();

        Poll poll = null;

        if (filter != null && !filter.isEmpty()) {
            poll = pollRepository.findByTitle(filter);
        }

        model.addAttribute("polls", polls);
        model.addAttribute("filter", filter);
        model.addAttribute("poll", poll);

        return "main";
    }

    @PostMapping
    public String addNewPoll(Model model) {

        return "main";
    }
}
