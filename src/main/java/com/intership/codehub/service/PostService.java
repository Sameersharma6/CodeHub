package com.intership.codehub.service;

import com.intership.codehub.entity.Post;
import java.util.List;

public interface PostService {
    Post createPost(Post post, Long userId);
    List<Post> getAllPosts();
    List<Post> getPostsByUser(Long userId);
    Post getPostById(Long id);
    void deletePost(Long id);
}

