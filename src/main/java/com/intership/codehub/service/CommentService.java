package com.intership.codehub.service;

import com.intership.codehub.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getCommentsByProblem(Long problemId);
    List<Comment> getCommentsByUser(Long userId);
}
