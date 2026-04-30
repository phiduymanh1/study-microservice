package org.example.studymicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.studymicroservice.dto.response.UserResponse;
import org.example.studymicroservice.entity.User;
import org.example.studymicroservice.mapper.UserMapper;
import org.example.studymicroservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserResponse getUserById(Integer id) {
    User user =
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    return userMapper.toUserResponse(user);
  }
}
