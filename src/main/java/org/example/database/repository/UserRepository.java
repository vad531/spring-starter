package org.example.database.repository;

import org.example.database.entity.Role;
import org.example.database.entity.User;
import org.example.dto.IPersonalInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u.firstname, u.lastname, u.birth_date birthDate from users u " +
            "where u.company_id = :companyId",
            nativeQuery = true)
    List<IPersonalInfo> findAllByCompanyId(Integer companyId);

    Page<User> findAllBy(Pageable pageable);

    List<User> findFirst3By(Sort sort);

    @Query("select u from User u " +
            "where u.firstName like %:firstname% and u.lastName like %:lastname%")
    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    List<User> findByRoleAndBirthDateBetween(Role role, LocalDate startDate, LocalDate endDate);
}