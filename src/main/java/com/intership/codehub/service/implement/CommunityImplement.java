package com.intership.codehub.service.implement;

import com.intership.codehub.entity.Comment;
import com.intership.codehub.entity.Post;
import com.intership.codehub.repository.CommentRepository;
import com.intership.codehub.repository.PostRepository;
import com.intership.codehub.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityImplement implements CommunityService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Comment addComment(Long postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }
}
