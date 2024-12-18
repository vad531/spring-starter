package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.database.repository.UserRepository;
import org.example.mapper.UserMapper;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
}