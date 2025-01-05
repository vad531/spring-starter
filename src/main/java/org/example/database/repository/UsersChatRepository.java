package org.example.database.repository;

import org.example.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersChatRepository extends JpaRepository<Company, Integer> {

}
