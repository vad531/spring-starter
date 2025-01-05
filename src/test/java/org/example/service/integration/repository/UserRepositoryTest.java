package org.example.service.integration.repository;

import annotation.IT;
import lombok.RequiredArgsConstructor;
import org.example.database.entity.Role;
import org.example.database.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

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
}
