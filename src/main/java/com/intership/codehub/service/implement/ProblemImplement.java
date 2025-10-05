package com.intership.codehub.service.implement;

import com.intership.codehub.entity.Problem;
import com.intership.codehub.enumtype.Difficulty;
import com.intership.codehub.repository.ProblemRepository;
import com.intership.codehub.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemImplement implements ProblemService {

    private final ProblemRepository problemRepository;

    @Override
    public Problem createProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    @Override
    public List<Problem> getProblemsByDifficulty(Difficulty difficulty) {
        return problemRepository.findByDifficulty(difficulty);
    }

    @Override
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }
}
