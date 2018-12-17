package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Subscribe;
import com.netcracker.edu.backend.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subscribe")
public class SubscribeController {

    private SubscribeService subscribeService;

    @Autowired
    public SubscribeController(SubscribeService subscribeService){

        this.subscribeService = subscribeService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<Subscribe> getSubscribeById(@PathVariable(name = "id") Long id){
        Optional<Subscribe> subscribe = subscribeService.getSubscribeById(id);
        if(subscribe.isPresent()){
            return ResponseEntity.ok(subscribe.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<Subscribe> getAllSubscribe(){
        return subscribeService.getAllSubscribe();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public Subscribe saveSubscribe(@RequestBody Subscribe subscribe){
        return this.subscribeService.saveSubscribe(subscribe);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteSubscribeById(@PathVariable(name = "id") Long id){
        this.subscribeService.deleteSubscribe(id);
        return ResponseEntity.noContent().build();
    }//ответ


    @RequestMapping(value = "/page" , method = RequestMethod.GET)
    public Page<Subscribe> getPage(@PageableDefault( sort = {"subscribeId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return this.subscribeService.getSubscribePage(pageable);
    }

    @RequestMapping(value="/getByAccount/{accountId}", method = RequestMethod.GET)
    public Iterable<Subscribe> getSubscriptionsByLogin(@PathVariable("accountId") Long accountId) {
        return subscribeService.getSubscribeByAccountId(accountId);
    }

}
