package com.example.demo.service;





import com.example.demo.entity.Post;

import java.util.List;

    public interface PostService {
        Post createPost(Post post, Integer userId);
        Post getPostById(Integer postId);
        List<Post> getAllPosts();
        Post updatePost(Integer postId, Post updatedPost);



        void deletePost(Integer postId);
         List<Post> searchposts(String keyword);

}
