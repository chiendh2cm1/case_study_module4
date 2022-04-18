package com.codegym.casestudymodule4.repository.comment;

import com.codegym.casestudymodule4.model.comment.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
