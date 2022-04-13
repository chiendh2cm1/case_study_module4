package com.codegym.casestudymodule4.controller;

import com.codegym.casestudymodule4.exception.ResourceNotFoundException;
import com.codegym.casestudymodule4.model.comment.Comment;
import com.codegym.casestudymodule4.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable(value = "id") Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
    }

    @PutMapping("/comments/{id}")
    public Comment updateComment(@PathVariable(value = "id") Long commentId, @RequestBody Comment commentDetails) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        comment.setPostName(commentDetails.getPostName());
        comment.setComment(commentDetails.getComment());

        Comment updatedComment = commentRepository.save(comment);
        return updatedComment;
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        commentRepository.delete(comment);

        return ResponseEntity.ok().build();
    }
}
