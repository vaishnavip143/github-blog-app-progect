package com.example.demo.controller;


import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Create
    @PostMapping("/post/{postId}")
    public ResponseEntity<?> createComment(@PathVariable Integer postId, @RequestBody Comment comment) {
        try {
            Comment savedComment = commentService.createComment(postId, comment);
            return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Failed to create comment: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Read all by post
    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getCommentsByPostId(@PathVariable Integer postId) {
        try {
            return new ResponseEntity<>(commentService.getAllCommentsByPostId(postId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Comments not found for postId: " + postId, HttpStatus.NOT_FOUND);
        }
    }

    // Read by ID
    @GetMapping("/{commentId}")
    public ResponseEntity<?> getCommentById(@PathVariable Integer commentId) {
        try {
            return new ResponseEntity<>(commentService.getCommentById(commentId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Comment not found with id: " + commentId, HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable Integer commentId, @RequestBody Comment updatedComment) {
        try {
            return new ResponseEntity<>(commentService.updateComment(commentId, updatedComment), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Cannot update. Comment not found with id: " + commentId, HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer commentId) {
        try {
            commentService.deleteComment(commentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Cannot delete. Comment not found with id: " + commentId, HttpStatus.NOT_FOUND);
        }
    }
}
