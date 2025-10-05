package com.intership.codehub.service.implement;

import com.intership.codehub.entity.Comment;
import com.intership.codehub.repository.CommentRepository;
import com.intership.codehub.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentImplement implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByProblem(Long problemId) {
        return commentRepository.findByPostId(problemId); // fixed mapping
    }

    @Override
    public List<Comment> getCommentsByUser(Long userId) {
        return commentRepository.findByUserId(userId);
    }
}
