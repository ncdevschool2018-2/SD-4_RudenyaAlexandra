package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.repository.CommentRepository;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentServiceImpl implements CommentService {

    private CommentRepository repository;

    @Autowired
    public CommentServiceImpl(CommentRepository repository) {

        this.repository = repository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return this.repository.save(comment);
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Comment> getAllComment() {
        return this.repository.findAll();
    }

    @Override
    public void deleteComment(Long id) {
        this.repository.deleteById(id);
    }
}
