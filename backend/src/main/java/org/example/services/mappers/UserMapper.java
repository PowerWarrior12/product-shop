package org.example.services.mappers;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.dto.user.AuthenticationUserDto;
import org.example.dto.user.RegistrationUserDto;
import org.example.dto.user.UserRequestDto;
import org.example.enums.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    public Authentication mapAuthenticationUserDtoToAuthentication(AuthenticationUserDto authenticationUserDto) {
        return new UsernamePasswordAuthenticationToken(authenticationUserDto.getLogin(), authenticationUserDto.getPassword());
    }

    public User registrationUserDtoToUser(RegistrationUserDto registrationUserDto) {
        User user = new User();
        user.setLogin(registrationUserDto.getLogin());
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        user.setName(registrationUserDto.getName());
        user.setLastName(registrationUserDto.getLastName());
        user.setPhoneNumber(registrationUserDto.getPhoneNumber());
        user.setRoles(List.of(Role.CUSTOMER));

        return user;
    }

    public UserRequestDto userToUserRequestDto(User user) {
        return new UserRequestDto(
                user.getLogin(),
                user.getName(),
                user.getLastName(),
                user.getPhoneNumber()
        );
    }

    public UserDetails userToUserDetails(User user) {
        return new org.springframework.security.core.userdetails.User(
            user.getLogin(),
            user.getPassword(),
            user.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.name()))
                    .toList()
        );
    }
}
