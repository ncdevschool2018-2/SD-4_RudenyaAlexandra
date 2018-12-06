package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CommentService {
    Comment saveComment(Comment comment);
    Optional<Comment> getCommentById(Long id);
    Iterable<Comment> getAllComment();
    void deleteComment(Long id);
    Page<Comment> getCommentPage(Pageable pageable);
}
