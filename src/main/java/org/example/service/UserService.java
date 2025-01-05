package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.database.repository.UserRepository;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
}