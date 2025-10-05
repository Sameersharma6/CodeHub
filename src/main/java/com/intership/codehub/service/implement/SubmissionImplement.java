package com.intership.codehub.service.implement;

import com.intership.codehub.entity.Submission;
import com.intership.codehub.entity.User;
import com.intership.codehub.enumtype.Status;
import com.intership.codehub.repository.SubmissionRepository;
import com.intership.codehub.repository.UserRepository;
import com.intership.codehub.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionImplement implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;

    @Override
    public Submission submitSolution(Submission submission) {
        Submission saved = submissionRepository.save(submission);

        // ✅ Update score if solution accepted
        if (submission.getStatus() == Status.ACCEPTED) {
            User user = submission.getUser();

            // Example scoring based on difficulty
            int scoreToAdd = switch (submission.getProblem().getDifficulty()) {
                case EASY -> 10;
                case MEDIUM -> 20;
                case MODERATE -> 30;
                case HARD -> 50;
            };

            user.setScore(user.getScore() + scoreToAdd);
            userRepository.save(user);
        }

        return saved;
    }

    @Override
    public List<Submission> getUserSubmissions(Long userId) {
        return submissionRepository.findByUserId(userId);
    }
}
