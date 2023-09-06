package org.example.services;

import org.example.dto.user.UserRequestDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    UserRequestDto loadUserByLoginIfExist(String login) throws UsernameNotFoundException;
}
