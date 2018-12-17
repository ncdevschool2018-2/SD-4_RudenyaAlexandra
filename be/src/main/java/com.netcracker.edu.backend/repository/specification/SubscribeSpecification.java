package com.netcracker.edu.backend.repository.specification;

import com.netcracker.edu.backend.entity.Subscribe;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SubscribeSpecification {
    public static Specification<Subscribe> subscribeByAccountId(Long accountId) {
        return new Specification<Subscribe>() {
            @Override
            public Predicate toPredicate(Root<Subscribe> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("account").get("accountId"), accountId);
            }
        };
    }
}
