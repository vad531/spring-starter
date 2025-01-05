package org.example;

import org.example.database.entity.Role;
import org.example.database.entity.User;
import org.example.database.entity.UserSpecifications;
import org.example.database.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class ApplicationRunner {


    public static void main(String[] args) {

        var context = SpringApplication.run(ApplicationRunner.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        System.out.println(SpringProperties.getProperty("test.msg"));

        Pageable pageable = PageRequest.of(0, 4);
        List<User> users = userRepository.findFirst4Users(pageable);
        System.out.println("Первые 4 пользователя:");
        users.forEach(user -> System.out.println(user.getUsername()));

        Sort sortByBirthDate = Sort.by("birthDate");
        List<User> sortedByBirthDate = userRepository.findAll(sortByBirthDate);
        System.out.println("\nСортировка по дате рождения:");
        sortedByBirthDate.forEach(user ->
                System.out.println(user.getUsername() + " - " + user.getBirthDate()));

        Sort sortByBirthDateAndFio = Sort.by("birthDate").and(Sort.by("firstName")).and(Sort.by("lastName"));
        List<User> sortedByBirthDateAndFio = userRepository.findAll(sortByBirthDateAndFio);
        System.out.println("\nСортировка по дате рождения и ФИО:");
        sortedByBirthDateAndFio.forEach(user ->
                System.out.println(user.getUsername() + " - " + user.getBirthDate()
                        + " - " + user.getFirstName() + " " + user.getLastName()));

        Role role = Role.ADMIN;
        Pageable pageableWithSorting = PageRequest.of(0, 3, Sort.by("birthDate").descending()); // Пагинация и сортировка по дате рождения
        Page<User> filteredUsersPage = userRepository.findAll(UserSpecifications.hasRole(role), pageableWithSorting);

        System.out.println("\nФильтр по роли ADMIN с пагинацией и сортировкой:");
        filteredUsersPage.forEach(user ->
                System.out.println(user.getUsername() + " - " + user.getRole() + " - " + user.getBirthDate()));
    }
}