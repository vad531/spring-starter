package org.example.service.integration.repository;

import annotation.IT;
import lombok.RequiredArgsConstructor;
import org.example.database.entity.Role;
import org.example.database.entity.User;
import org.example.database.entity.UserSpecifications;
import org.example.database.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    void findAdminsBornBetween() {
        var startDate = LocalDate.of(1980, 1, 1);
        var endDate = LocalDate.of(1995, 12, 31);
        var admins = userRepository.findByRoleAndBirthDateBetween(Role.ADMIN, startDate, endDate);

        assertThat(admins).hasSize(2);
    }

    @Test
    void shouldFindFirst4Users() {
        Pageable pageable = PageRequest.of(0, 4);
        List<User> users = userRepository.findFirst4Users(pageable);

        assertNotNull(users);
        assertEquals(4, users.size());
    }

    @Test
    void shouldSortUsersByBirthDate() {
        Sort sort = Sort.by("birthDate").and(Sort.by("username"));
        List<User> users = userRepository.findAll(sort);

        assertNotNull(users);
        assertTrue(users.stream().allMatch(user -> user.getBirthDate() != null));

        for (int i = 0; i < users.size() - 1; i++) {
            LocalDate current = users.get(i).getBirthDate();
            LocalDate next = users.get(i + 1).getBirthDate();
            assertTrue(current.isBefore(next) || current.isEqual(next));
        }
    }

    @Test
    void shouldFilterByRoleAndSortAndPaginate() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("birthDate"));
        Specification<User> spec = UserSpecifications.hasRole(Role.ADMIN);

        Page<User> usersPage = userRepository.findAll(spec, pageable);

        assertNotNull(usersPage);
        assertEquals(5, usersPage.getSize());
        assertTrue(usersPage.getContent().stream().allMatch(user -> user.getRole() == Role.ADMIN));
    }
}
