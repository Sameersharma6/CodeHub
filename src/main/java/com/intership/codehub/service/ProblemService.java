package com.intership.codehub.service;

import com.intership.codehub.entity.Problem;
import com.intership.codehub.enumtype.Difficulty;

import java.util.List;

public interface ProblemService {
    Problem createProblem(Problem problem);
    List<Problem> getProblemsByDifficulty(Difficulty difficulty);
    List<Problem> getAllProblems();
}
