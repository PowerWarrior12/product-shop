package org.example.services;

import org.example.dto.user.AuthenticationUserDto;
import org.example.dto.user.RegistrationUserDto;

public interface AuthenticationService {
    public String login(AuthenticationUserDto authenticationUserDto);
    public void registration(RegistrationUserDto registrationUserDto);
}
