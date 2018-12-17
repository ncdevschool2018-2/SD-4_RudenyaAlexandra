package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Subscribe;
import com.netcracker.edu.backend.repository.SubscribeRepository;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.ChargeService;
import com.netcracker.edu.backend.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private SubscribeRepository subscribeRepository;

    private List<Subscribe> subscribe = new ArrayList<>();

    //@Scheduled(fixedDelay = 5000)
    @Override
    public void scheduledCharge() {
        loadSubscription();
        decreaseAmount();
        System.out.println("+");
    }

    @Override
    public void loadSubscription() {
        Iterable<Subscribe> iterableSubs = subscribeRepository.findAll();
        for (Subscribe sub : iterableSubs) {
            subscribe.add(sub);
        }
    }

    @Override
    public boolean checkStatus(Subscribe subscribe) {
        boolean status;
        Date localDate = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");

        if(!localDate.before(subscribe.getEndDate()) ||
                subscribe.getAccount().getWallet().getBalance() <
                        subscribe.getProduct().getCost()) {
            status = false;
            subscribeRepository.falseStatus(subscribe.getSubscribeId());
        }
        else {
            status = true;
            subscribeRepository.trueStatus(subscribe.getSubscribeId());
        }
        return status;
    }

    @Override
    public void decreaseAmount() {
        for (Subscribe s: subscribe) {
            if (checkStatus(s)){
                walletRepository.updateBalanceWallet(s.getProduct().getCost(),
                        s.getAccount().getWallet().getWalletId());
            }
        }
    }


}
