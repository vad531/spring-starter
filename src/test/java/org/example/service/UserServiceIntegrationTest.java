package org.example.service;

import org.example.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser() {
        UserDto userDto = new UserDto("testUser", "password123", "test@example.com");

        UserDto registeredUser = userService.registerUser(userDto);

        assertNotNull(registeredUser);
        assertEquals("testUser", registeredUser.getUsername());
        assertEquals("test@example.com", registeredUser.getEmail());
    }
}