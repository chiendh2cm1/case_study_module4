package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoriesComment extends JpaRepository<Comment, Long> {
}
