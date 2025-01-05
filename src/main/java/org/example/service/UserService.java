package org.example.service;

import lombok.ToString;
import org.example.database.entity.Role;
import org.example.database.entity.User;
import org.example.database.entity.UserSpecifications;
import org.example.database.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@ToString
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getUsersByRoleWithSortingAndPagination(Role role, int page, int size, String sortBy) {
        Specification<User> spec = UserSpecifications.hasRole(role);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userRepository.findAll(spec, pageable);
    }
}