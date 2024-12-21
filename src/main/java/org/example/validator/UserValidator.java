package org.example.validator;

import org.example.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
    public void validate(UserDto userDto) {
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (userDto.getEmail() == null || !userDto.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}