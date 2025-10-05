package com.intership.codehub.service;

import com.intership.codehub.entity.Comment;
import com.intership.codehub.entity.Post;

import java.util.List;

public interface CommunityService {
    Post createPost(Post post);
    List<Post> getAllPosts();
    Comment addComment(Long postId, Comment comment);
}
