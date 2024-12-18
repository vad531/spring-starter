package org.example.mapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.dto.UserDto;

@RequiredArgsConstructor
@ToString
public class UserMapper {
    private final UserDto userDto;
}
