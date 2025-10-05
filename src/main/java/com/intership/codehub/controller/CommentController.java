package com.intership.codehub.controller;

import com.intership.codehub.entity.Comment;
import com.intership.codehub.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // Add a new comment
    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.addComment(comment));
    }

    // Get all comments for a problem
    @GetMapping("/problem/{problemId}")
    public ResponseEntity<List<Comment>> getCommentsByProblem(@PathVariable Long problemId) {
        return ResponseEntity.ok(commentService.getCommentsByProblem(problemId));
    }

    // Get all comments by a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comment>> getCommentsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(commentService.getCommentsByUser(userId));
    }
}
