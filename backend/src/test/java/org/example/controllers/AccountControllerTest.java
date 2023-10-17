package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.user.AuthenticationUserDto;
import org.example.dto.user.RegistrationUserDto;
import org.example.services.AuthenticationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AuthenticationService authenticationService;

    @Test
    @DisplayName("[200] POST /account/login - login contains account")
    void login() throws Exception {
        String tokenExpected = "JWT_TOKEN";
        AuthenticationUserDto dto = new AuthenticationUserDto("test@mail.ru", "1234567");
        when(authenticationService.login(any(AuthenticationUserDto.class))).thenReturn(tokenExpected);
        mockMvc.perform(post("/account/login")
                        .content(objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(tokenExpected));
    }

    @Test
    @DisplayName("[200] POST /account/registration - registration new account")
    void registration() throws Exception {
        String resultExpected = "Registration success";
        RegistrationUserDto dto = new RegistrationUserDto("test@mail.ru", "1234567", "1234567", "Test", "Test", "+77777777777");
        mockMvc.perform(post("/account/registration")
                        .content(objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(resultExpected));
    }
}