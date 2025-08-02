package com.example.demo.service.serviceimpl;
import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class PostServiceImpl implements PostService {

        @Autowired
        private PostRepository postRepository;

        @Autowired
        private UserRepository userRepository;

        @Override
        public Post createPost(Post post, Integer userId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
            post.setUser(user);
            return postRepository.save(post);
        }

        @Override
        public Post getPostById(Integer postId) {
            return postRepository.findById(postId)
                    .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        }

        @Override
        public List<Post> getAllPosts() {
            return postRepository.findAll();
        }

        @Override
        public Post updatePost(Integer postId, Post updatedPost) {
            Post existingPost = postRepository.findById(postId)
                    .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

            if (updatedPost.getTitle() != null)
                existingPost.setTitle(updatedPost.getTitle());

            if (updatedPost.getContent() != null)
                existingPost.setContent(updatedPost.getContent());

            if (updatedPost.getImageName() != null)
                existingPost.setImageName(updatedPost.getImageName());

            return postRepository.save(existingPost);
        }

        @Override
        public void deletePost(Integer postId) {
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
            postRepository.delete(post);
        }

        @Override
        public List<Post> searchposts(String keyword) {
            List<Post> posts= postRepository.findByTitleContaining(keyword);
            return posts;
        }
    }


