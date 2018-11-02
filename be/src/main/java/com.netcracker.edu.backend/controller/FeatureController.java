package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Feature;
import com.netcracker.edu.backend.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {

    private FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService){
        this.featureService = featureService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<Feature> getFeatureById(@PathVariable(name = "id") Long id){
        Optional<Feature> feature = featureService.getFeatureById(id);
        if(feature.isPresent()){
            return ResponseEntity.ok(feature.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<Feature> getAllFeature(){
        return featureService.getAllFeature();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public Feature saveFeature(@RequestBody Feature feature){
        return this.featureService.saveFeature(feature);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteFeatureById(@PathVariable(name = "id") Long id){
        this.featureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }//ответ
}
