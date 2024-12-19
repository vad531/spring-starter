package org.example.database.repository;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@ToString
@Slf4j
public class UserRepository {
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.poll.size}")
    private int poolSize;
    private List<Object> args;
    private Map<String, Object> properties;

    // Метод для инициализации соединения с базой данных
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Не удалось загрузить JDBC-драйвер: " + driver, e);
        }
    }

    // Метод для поиска пользователя по ID (пример)
    public void findUserById(int id) {
        try (Connection connection = getConnection()) {
            System.out.println("Соединение с БД установлено!");
            System.out.println("Выполняется запрос для пользователя с ID: " + id);
            // Здесь можно добавить SQL-запрос
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к БД: " + e.getMessage());
        }
    }

    public void addUser(String name, String email) {
        log.info("Добавление пользователя в базу...");
        log.info("Имя: {}, Email: {}", name, email);
        log.info("Заглушка: пользователь успешно добавлен (фиктивно).");
    }
    @PostConstruct
    private void init() {
        log.info("Init connection pool");
    }
}
