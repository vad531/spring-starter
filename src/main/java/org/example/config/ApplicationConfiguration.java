package org.example.config;

import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("org.example")
public class ApplicationConfiguration {
    @Bean
    @Profile("prod")
    public String prodProfile() {
        System.out.println("Активирован профиль: PROD");
        return "prod";
    }

    @Bean
    @Profile("test")
    public String testProfile() {
        System.out.println("Активирован профиль: TEST");
        return "test";
    }
}
