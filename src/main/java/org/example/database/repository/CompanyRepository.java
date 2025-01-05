package org.example.database.repository;

import org.example.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Company c SET c.name = :name WHERE c.id = :id")
    int updateCompanyNameById(Integer id, String name);

    @Modifying
    @Transactional

    void deleteAllByNameStartingWith(String prefix);
}