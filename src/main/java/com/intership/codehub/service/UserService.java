package com.intership.codehub.service;

import com.intership.codehub.entity.User;
import com.intership.codehub.enumtype.Level;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findByEmail(String email);
    User updateLevel(Long userId, Level level);
    List<User> getLeaderboard();
}
