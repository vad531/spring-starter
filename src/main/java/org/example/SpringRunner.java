package org.example;

import org.example.config.ApplicationConfiguration;
import org.example.database.repository.UserRepository;
import org.example.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            // Получаем Bean UserRepository
            var userRepository = context.getBean(UserRepository.class);
            userRepository.findUserById(1);

            // Получаем Bean CompanyService
            var companyService = context.getBean(CompanyService.class);
            companyService.findById(1);
        }
    }
}