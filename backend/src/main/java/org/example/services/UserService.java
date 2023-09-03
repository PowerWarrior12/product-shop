package org.example.services;

import org.example.domain.User;
import org.example.dto.user.UserRequestDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {
    UserRequestDto loadUserByLoginIfExist(String login) throws UsernameNotFoundException;
}
