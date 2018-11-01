package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.entity.Feature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends CrudRepository<Feature, Long> {//с помощью CrudRep мы сможем вызывать различные методы
}
