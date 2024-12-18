package org.example.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class UserRepository {
    private String userName;
    private String password;
    private String url;
    private String driver;
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
}
