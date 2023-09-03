package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.dto.user.UserRequestDto;
import org.example.repositories.UserRepository;
import org.example.services.UserService;
import org.example.services.mappers.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserRequestDto loadUserByLoginIfExist(String login) {
        User user = userRepository.findByLogin(login).orElseThrow();
        return userMapper.userToUserRequestDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with username %s not found", username));
        }
        return userMapper.userToUserDetails(user.get());
    }
}
