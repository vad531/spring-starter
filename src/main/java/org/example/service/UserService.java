package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.database.entity.UserEntity;
import org.example.database.repository.UserRepository;
import org.example.dto.UserDto;
import org.example.mapper.UserMapper;
import org.example.validator.UserValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    public UserDto registerUser(UserDto userDto) {
        userValidator.validate(userDto);

        // Преобразование DTO в Entity
        UserEntity userEntity = userMapper.toEntity(userDto);

        // Заглушка вместо сохранения в БД
        userEntity.setId(1L); // Симулируем, что пользователь сохранён с ID = 1

        // Преобразование Entity обратно в DTO
        return userMapper.toDto(userEntity);
    }
}