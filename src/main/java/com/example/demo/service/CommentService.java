package com.example.demo.service;


import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentService {
        Comment createComment( Integer postId, Comment comment);



    Comment getCommentById(Integer commentId);

    List<Comment> getAllCommentsByPostId(Integer postId);

    List<Comment> getAllComments();

    Comment updateComment(Integer commentId, Comment updatedComment);
        void deleteComment(Integer commentId);
    }


