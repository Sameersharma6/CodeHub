package com.intership.codehub.controller;

import com.intership.codehub.entity.User;
import com.intership.codehub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";  // always redirect root → /login
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("user", new User("Sameer", "BEGINNER", 50));
        return "home";  // loads home.html
    }

    @GetMapping("/leaderboard")
    public String leaderboardPage(Model model) {
        model.addAttribute("users", userService.getLeaderboard());
        return "leaderboard"; // loads leaderboard.html
    }

    @GetMapping("/register-page")
    public String registerPage() {
        return "register"; // loads register.html
    }
}
