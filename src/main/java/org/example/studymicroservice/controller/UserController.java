package org.example.studymicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.studymicroservice.dto.response.UserResponse;
import org.example.studymicroservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.PATH)
@RequiredArgsConstructor
public class UserController {

  public static final String PATH = "/user";

  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUser(@PathVariable int id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }
}
