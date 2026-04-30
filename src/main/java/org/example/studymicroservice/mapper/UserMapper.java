package org.example.studymicroservice.mapper;

import org.example.studymicroservice.dto.response.UserResponse;
import org.example.studymicroservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserResponse toUserResponse(User user);
}
