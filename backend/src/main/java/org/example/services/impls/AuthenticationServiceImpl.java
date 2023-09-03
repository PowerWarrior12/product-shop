package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.dto.user.AuthenticationUserDto;
import org.example.dto.user.RegistrationUserDto;
import org.example.exceptions.ApiRequestException;
import org.example.exceptions.GenerateJwtTokenException;
import org.example.exceptions.LoginAlreadyExistException;
import org.example.exceptions.PasswordNotMatchException;
import org.example.repositories.UserRepository;
import org.example.security.JwtProvider;
import org.example.services.AuthenticationService;
import org.example.services.UserService;
import org.example.services.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;

    @Override
    public String login(AuthenticationUserDto authenticationUserDto) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(userMapper.mapAuthenticationUserDtoToAuthentication(authenticationUserDto));
            return jwtProvider.generateToken(authentication);
        } catch (GenerateJwtTokenException exception) {
            throw new ApiRequestException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (AuthenticationException exception) {
            throw new ApiRequestException(exception.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public void registration(RegistrationUserDto registrationUserDto) {
        String login = registrationUserDto.getLogin();
        if (userRepository.findByLogin(login).isPresent()) {
            throw new LoginAlreadyExistException(String.format("Login: %s already exist", login),login);
        }
        if (registrationUserDto.getPassword() != null && !registrationUserDto.getPassword().equals(registrationUserDto.getRepeatPassword())) {
            throw new PasswordNotMatchException("Passwords don't match");
        }
        userRepository.saveAndFlush(userMapper.registrationUserDtoToUser(registrationUserDto));
    }
}
