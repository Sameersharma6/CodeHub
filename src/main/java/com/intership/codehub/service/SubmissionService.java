package com.intership.codehub.service;

import com.intership.codehub.entity.Submission;

import java.util.List;

public interface SubmissionService {
    Submission submitSolution(Submission submission);
    List<Submission> getUserSubmissions(Long userId);
}
