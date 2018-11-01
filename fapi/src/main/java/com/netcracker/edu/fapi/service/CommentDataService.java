package com.netcracker.edu.fapi.service;


import com.netcracker.edu.fapi.entity.CommentViewModel;

import java.util.List;

public interface CommentDataService {
    List<CommentViewModel> getAll();
    CommentViewModel getCommentById(Long id);
    CommentViewModel saveComment(CommentViewModel comment);
    void deleteComment(Long id);
}
