package org.example;

import org.example.database.repository.UserRepository;
import org.example.service.CompanyService;
import org.example.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("application.xml");
        var userRepository = context.getBean("repo1", UserRepository.class);
        var companyService = context.getBean("companyService", CompanyService.class);

//        var userService = (UserService) context.getBean("userService");
//        System.out.println(userRepository);

        userRepository.findUserById(1);
        companyService.findCompanyById(1001);
    }
}
