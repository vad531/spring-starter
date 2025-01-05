package org.example.database.entity;

import org.springframework.data.jpa.domain.Specification;


public class UserSpecifications {
    public static Specification<User> hasRole(Role role) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("role"), role);
    }
}