package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.user.AuthenticationUserDto;
import org.example.dto.user.RegistrationUserDto;
import org.example.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AuthenticationService authenticationService;
    /**
     * @return Return JWT token based on authentication's account data
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationUserDto authenticationUserDto) {
        return ResponseEntity.ok(authenticationService.login(authenticationUserDto));
    }
    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationUserDto registrationUserDto) {
        authenticationService.registration(registrationUserDto);
        return ResponseEntity.ok("Registration success");
    }
}
