package org.example.security;

import org.example.enums.Role;
import org.example.exceptions.GenerateJwtTokenException;
import org.example.security.testConfiguration.TestConfiguration;
import org.example.utils.TimeProvider;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource("/application-test.properties")
@Import(TestConfiguration.class)
class JwtProviderTest {
    @Autowired
    private JwtProvider jwtProvider;
    @Test
    @DisplayName("generate token test")
    public void generateTokenTest() throws GenerateJwtTokenException {
        String username = "Peter";
        String password = "1234567";
        Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(Role.CUSTOMER.name()));

        String verificationJwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlcyI6WyJDVVNUT01FUiJdLCJzdWIiOiJQZXRlciIsImlhdCI6MTY5MzczNTIwMCwiZXhwIjoxNjkzNzM3MDAwLCJpc3MiOiJpc3N1ZXIifQ.5p0AADGtggpD2JoWokf_ftQ-CR1bSRWfW6rc0X6fo5g";

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, authorities);

        String jwtToken = jwtProvider.generateToken(authenticationToken);

        Assertions.assertEquals(jwtToken, verificationJwtToken, "Token not valid");
    }
}