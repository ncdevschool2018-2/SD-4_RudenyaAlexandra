package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subscribe;

public interface ChargeService {

    void scheduledCharge();
    void loadSubscription();
    boolean checkStatus(Subscribe subscribe);
    void decreaseAmount();
}
