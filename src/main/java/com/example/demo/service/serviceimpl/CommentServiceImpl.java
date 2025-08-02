package com.example.demo.service.serviceimpl;
import com.example.demo.entity.Comment;

import com.example.demo.entity.Post;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public Comment createComment(Integer postId,Comment comment) {  // Change postId to Long
        // Fetch the post by ID
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

        // Associate the comment with the post
        comment.setPost(post);

        // Save the comment and return it
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        // Fetch the comment by ID
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId));
    }

    @Override
    public List<Comment> getAllCommentsByPostId(Integer postId) {
        return List.of();
    }

    @Override
    public List<Comment> getAllComments() {
        // Return all comments
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Integer commentId, Comment updatedComment) {
        // Fetch the existing comment by ID
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId));

        // Update the fields of the existing comment
        if (updatedComment.getContent() != null) {
            existingComment.setContent(updatedComment.getContent());
        }

        // Save the updated comment and return it
        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        // Fetch the comment by ID
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId));

        // Delete the comment
        commentRepository.delete(comment);
    }
}
