package org.example.studymicroservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.PATH)
public class UserController {

    public static final String PATH = "/user";

    @GetMapping("/{id}")
    public ResponseEntity<Integer> getUser(@PathVariable int id) {
        return ResponseEntity.ok(id);
    }
}
