package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.CommentViewModel;
import com.netcracker.edu.fapi.service.CommentDataService;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class CommentDataServiceImpl implements CommentDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<CommentViewModel> getAll() {

    }

    @Override
    public CommentViewModel getCommentById(Long id) {
        return null;
    }

    @Override
    public CommentViewModel saveComment(CommentViewModel comment) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {

    }
}
