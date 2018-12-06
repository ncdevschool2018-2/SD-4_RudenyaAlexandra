package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Subscribe;
import com.netcracker.edu.backend.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface SubscribeRepository extends
        JpaRepository<Subscribe, Long> {

        @Modifying
        @Transactional
        @Query("update Subscribe sub set sub.status = false where sub.id = :id")
        void falseStatus(@Param("id") Long id);

        @Modifying
        @Transactional
        @Query("update Subscribe sub set sub.status = true where sub.id = :id")
        void trueStatus(@Param("id") Long id);
}