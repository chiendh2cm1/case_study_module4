package com.codegym.casestudymodule4.controller.comment;

import com.codegym.casestudymodule4.model.bill.Bill;
import com.codegym.casestudymodule4.model.comment.Comment;
import com.codegym.casestudymodule4.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    ICommentService commentService;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> getAll() {
        Iterable<Comment> comments = commentService.findAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> createBill(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
    }
}
