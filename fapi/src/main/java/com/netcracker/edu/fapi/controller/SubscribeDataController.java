package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.SubscribeViewModel;
import com.netcracker.edu.fapi.service.SubscribeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscribe")
public class SubscribeDataController {

    @Autowired
    private SubscribeDataService subscribeDataService;

    @RequestMapping
    public ResponseEntity<List<SubscribeViewModel>> getAllSubscribe() {

        return ResponseEntity.ok(subscribeDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubscribeViewModel> getSubscribeById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(subscribeDataService.getSubscribeById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubscribeViewModel> saveSubscribe(@RequestBody SubscribeViewModel subscribe /*todo server validation*/) {
        if (subscribe != null) {
            return ResponseEntity.ok(subscribeDataService.saveSubscribe(subscribe));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubscribe(@PathVariable String id) {

        subscribeDataService.deleteSubscribe(Long.valueOf(id));
    }

}
