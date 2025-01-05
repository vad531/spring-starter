package org.example.pool;

import jakarta.annotation.PostConstruct;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ToString
public class ConnectionPool {
    private String username;
    private String password;
    private Integer poolSize;
    private String url;
    private final String driver;

    public ConnectionPool(@Value("${spring.datasource.username}") String username,
                          @Value("${spring.datasource.password}") String password,
                          @Value("${spring.datasource.pool.size}") Integer poolSize,
                          @Value("${spring.datasource.url}") String url,
    @Value("${spring.datasource.driver-class-name}") String driver){
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
        this.driver = driver;
    }

    @PostConstruct
    private void init() {
        log.info("Init connection pool");
    }
}