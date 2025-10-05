package com.intership.codehub.controller;

import com.intership.codehub.entity.User;
import com.intership.codehub.enumtype.Level;
import com.intership.codehub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    // Show login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // loads login.html
    }

    // Handle login form POST
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            // Add user details to model
            model.addAttribute("user", user);
            return "home"; // Show home.html with user data
        }

        // If invalid login
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    // Show register page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Handle registration
    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password,
                           Model model) {

        if (userRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }

        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password); // No encryption (since no security)
        user.setLevel(Level.valueOf("BEGINNER"));
        user.setScore(0);
        userRepository.save(user);

        model.addAttribute("message", "User registered successfully! Please login.");
        return "login";
    }
}
