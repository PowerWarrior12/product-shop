package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.user.AuthenticationUserDto;
import org.example.dto.user.RegistrationUserDto;
import org.example.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationUserDto authenticationUserDto) {
        return authenticationService.login(authenticationUserDto);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationUserDto registrationUserDto) {
        authenticationService.registration(registrationUserDto);
        return ResponseEntity.ok("Registration success");
    }

    @GetMapping("/test")
    public String test() {
        return "Test are successful";
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }
}
