package com.intership.codehub.service.implement;

import com.intership.codehub.entity.User;
import com.intership.codehub.enumtype.Level;
import com.intership.codehub.repository.UserRepository;
import com.intership.codehub.service.EmailService;
import com.intership.codehub.service.SmsService;
import com.intership.codehub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserImplement implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final SmsService smsService;

    @Override
    public User register(User user) {
        User saved = userRepository.save(user);

        // Send email
        emailService.sendMail(
                saved.getEmail(),
                "Welcome!",
                "Hello " + saved.getUsername() + ", welcome to CodeHub!"
        );

        // Send SMS
        smsService.sendSms(
                saved.getMobile(),
                "Welcome " + saved.getUsername() + " to CodeHub!"
        );

        return saved;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateLevel(Long userId, Level level) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setLevel(level);
        return userRepository.save(user);
    }

    @Override
    public List<User> getLeaderboard() {
        return userRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(User::getScore).reversed())
                .toList();
    }
}

