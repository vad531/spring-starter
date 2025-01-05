package org.example.mapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor
public class UserMapper {
    @Autowired
    private UserDto userDto;
}