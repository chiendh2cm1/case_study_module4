package com.codegym.casestudymodule4.service.comment;

import com.codegym.casestudymodule4.model.comment.Comment;
import com.codegym.casestudymodule4.model.product.Product;

import java.util.Optional;

public interface ICommentService {
    public Iterable<Comment> findAll();

    public Optional<Comment> findById(Long id);

    public Comment save(Comment comment);

    public void remove(Long id);
}
