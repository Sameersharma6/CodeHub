package com.intership.codehub.controller;

import com.intership.codehub.entity.User;
import com.intership.codehub.enumtype.Level;
import com.intership.codehub.service.UserService;
import com.intership.codehub.wrapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<ModelMapper<User>> register(@RequestBody User user) {
        User saved = userService.register(user);
        return ResponseEntity.ok(new ModelMapper<>("success", "User registered successfully", saved));
    }


    // Find by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<User>> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    // Update user level
    @PutMapping("/{id}/level")
    public ResponseEntity<User> updateLevel(@PathVariable Long id, @RequestParam Level level) {
        return ResponseEntity.ok(userService.updateLevel(id, level));
    }

    // Leaderboard
    @GetMapping("/leaderboard")
    public ResponseEntity<List<User>> leaderboard() {
        return ResponseEntity.ok(userService.getLeaderboard());
    }
}
