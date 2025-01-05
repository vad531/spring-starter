package org.example.service.integration.repository;

import annotation.IT;
import lombok.RequiredArgsConstructor;
import org.example.database.entity.Company;
import org.example.database.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor
@Transactional
public class CompanyRepositoryTest {

    private final CompanyRepository companyRepository;

    @Test
    void updateCompanyNameByIdTest() {

        Company company = companyRepository.findById(1)
                .orElseThrow(() -> new IllegalStateException("Company with id=1 not found in DB"));

        int updatedRows = companyRepository.updateCompanyNameById(company.getId(), "New Name");
        assertThat(updatedRows).isEqualTo(1);

        Company updatedCompany = companyRepository.findById(company.getId())
                .orElseThrow(() -> new IllegalStateException("Company with id=1 not found after update"));
        assertThat(updatedCompany.getName()).isEqualTo("New Name");
    }

    @Test
    void deleteAllByNameStartingWithTest() {
        companyRepository.deleteAllByNameStartingWith("A");

        List<Company> remainingCompanies = companyRepository.findAll();
        assertThat(remainingCompanies).hasSize(2);
    }
}
