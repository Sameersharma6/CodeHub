package com.intership.codehub.controller;

import com.intership.codehub.entity.Submission;
import com.intership.codehub.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {






        private final SubmissionService submissionService;

        // Submit solution
        @PostMapping
        public ResponseEntity<Submission> submit(@RequestBody Submission submission) {
            return ResponseEntity.ok(submissionService.submitSolution(submission));
        }

        // Get submissions by user
        @GetMapping("/user/{userId}")
        public ResponseEntity<List<Submission>> getByUser(@PathVariable Long userId) {
            return ResponseEntity.ok(submissionService.getUserSubmissions(userId));
        }
    }


