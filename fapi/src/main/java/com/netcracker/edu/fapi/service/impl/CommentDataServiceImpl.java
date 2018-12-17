package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.CommentViewModel;
import com.netcracker.edu.fapi.service.CommentDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommentDataServiceImpl implements CommentDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<CommentViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        CommentViewModel[] commentModelResponse = restTemplate.getForObject(backendServerUrl + "/api/comment/", CommentViewModel[].class);
        return commentModelResponse == null ? Collections.emptyList() : Arrays.asList(commentModelResponse);
    }

    @Override
    public CommentViewModel getCommentById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        CommentViewModel[] commentViewModels = restTemplate.getForObject(backendServerUrl + "/api/comment/", CommentViewModel[].class);

        if (commentViewModels != null) {
            for (CommentViewModel commentViewModel : commentViewModels) {
                if (commentViewModel.getCommentId() == id)
                    return commentViewModel;
            }
        }
        return null;
    }

    @Override
    public CommentViewModel saveComment(CommentViewModel comment) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/comment", comment, CommentViewModel.class).getBody();
    }

    @Override
    public void deleteComment(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/comment/" + id);
    }

    @Override
    public RestPageImpl<CommentViewModel> getCommentPage(HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(backendServerUrl + "/api/comment/page?" + request.getQueryString(),
                HttpMethod.GET, null,
                new ParameterizedTypeReference<RestPageImpl<CommentViewModel>>() {
                }).getBody();
    }
}
