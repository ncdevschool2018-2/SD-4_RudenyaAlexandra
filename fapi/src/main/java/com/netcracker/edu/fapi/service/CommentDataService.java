package com.netcracker.edu.fapi.service;


import com.netcracker.edu.fapi.entity.CommentViewModel;
import com.netcracker.edu.fapi.service.impl.RestPageImpl;
import org.springframework.data.domain.PageImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CommentDataService {
    List<CommentViewModel> getAll();
    CommentViewModel getCommentById(Long id);
    CommentViewModel saveComment(CommentViewModel comment);
    void deleteComment(Long id);
    RestPageImpl<CommentViewModel> getCommentPage(HttpServletRequest request);
}
