package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.entity.SubscribeViewModel;
import com.netcracker.edu.fapi.service.impl.RestPageImpl;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SubscribeDataService {
    List<SubscribeViewModel> getAll();
    SubscribeViewModel getSubscribeById(Long id);
    SubscribeViewModel saveSubscribe(SubscribeViewModel subscribe);
    void deleteSubscribe(Long id);
    List<SubscribeViewModel> getSubscribeByAccountId(Long accountId);
    RestPageImpl<SubscribeViewModel> getPage(HttpServletRequest request);
}
