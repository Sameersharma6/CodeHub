package com.intership.codehub.controller;

import com.intership.codehub.entity.Problem;
import com.intership.codehub.enumtype.Difficulty;
import com.intership.codehub.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    // Create new problem
    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem) {
        return ResponseEntity.ok(problemService.createProblem(problem));
    }

    // Get all problems
    @GetMapping
    public ResponseEntity<List<Problem>> getAllProblems() {
        return ResponseEntity.ok(problemService.getAllProblems());
    }

    // Get problems by difficulty
    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Problem>> getByDifficulty(@PathVariable Difficulty difficulty) {
        return ResponseEntity.ok(problemService.getProblemsByDifficulty(difficulty));
    }
}
