package org.example.controllers;

import org.example.dto.user.UserRequestDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<UserRequestDto> getUserByLogin(Principal principal) {
        return ResponseEntity.ok(userService.loadUserByLoginIfExist(principal.getName()));
    }
}
