package com.example.demo.controller;


import com.example.demo.entity.Post;
import com.example.demo.service.FileService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

    @RestController
    @RequestMapping("/api/posts")
    public class PostController {

        @Autowired
        private PostService postService;
        @Autowired
        private FileService fileService;
        @Value("${project.image}")
        private String path;

        // Create
        @PostMapping("/user/{userId}")
        public ResponseEntity<Post> createPost(@PathVariable Integer userId, @RequestBody Post post) {
            return new ResponseEntity<>(postService.createPost(post, userId), HttpStatus.CREATED);
        }

        // Read by ID
        @GetMapping("/{postId}")
        public ResponseEntity<Post> getPostById(@PathVariable Integer postId) {
            return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.OK);
        }

        // Read all
        @GetMapping("/")
        public ResponseEntity<List<Post>> getAllPosts() {
            return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
        }

        // Update
        @PutMapping("/{postId}")
        public ResponseEntity<Post> updatePost(@PathVariable Integer postId, @RequestBody Post post) {
            return new ResponseEntity<>(postService.updatePost(postId, post), HttpStatus.OK);
        }

        // Delete
        @DeleteMapping("/{postId}")
        public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
            postService.deletePost(postId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        @GetMapping("/posts/search/{keyword}")
        public ResponseEntity<List<Post>>searchPostByTitle(@PathVariable ("keyword")String keyword){
            List<Post> result=this.postService.searchposts(keyword);
            return new ResponseEntity<List<Post>>(result,HttpStatus.OK);


        }
        @PostMapping("/image/upload/{postId}")
        public ResponseEntity<Post>uploadPostImage(
                @RequestParam ("image") MultipartFile image,
                @PathVariable Integer postId)throws IOException {
            Post post = this.postService.getPostById(postId);
            String fileName =this.fileService.uploadImage(path,image);

            post.setImageName(fileName);
           Post updatePost= this.postService.updatePost(postId,post);
           return new ResponseEntity<>(updatePost,HttpStatus.OK);


        }
    }


