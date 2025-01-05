package org.example.service.integration;

import org.example.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestApplicationRunner {

    @Bean(name = "connectionPool2")
    public ConnectionPool connectionPool2() {
        return new ConnectionPool("username", "password", 10, "jdbc:h2:mem:testdb", "org.h2.Driver");
    }
}