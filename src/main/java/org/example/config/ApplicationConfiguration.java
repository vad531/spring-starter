package org.example.config;

import org.springframework.context.annotation.*;

@ImportResource("classpath:application.xml")
@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:application.properties")
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
