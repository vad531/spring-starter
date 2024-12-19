package org.example.mapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.database.entity.UserEntity;
import org.example.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor
public class UserMapper {

    public UserEntity toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        return userEntity;
    }

    public UserDto toDto(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        return new UserDto(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail()
        );
    }
}