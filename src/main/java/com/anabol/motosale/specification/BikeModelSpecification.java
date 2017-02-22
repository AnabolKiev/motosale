package com.anabol.motosale.specification;

import com.anabol.motosale.model.BikeModel;
import com.anabol.motosale.model.BikeModel_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class BikeModelSpecification {
    /**
     * Specification used to construct dynamic query based on JPA Criteria API.
     */
    public static Specification<BikeModel> category(final Long categoryId) {
        return new Specification<BikeModel>() {
            public Predicate toPredicate(Root<BikeModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(BikeModel_.category), categoryId);
            }
        };
    }
}