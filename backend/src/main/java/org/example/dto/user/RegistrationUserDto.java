package org.example.dto.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RegistrationUserDto {
    private final String login;
    private final String password;
    private final String repeatPassword;
    private final String name;
    private final String lastName;
    private final String phoneNumber;

    @JsonCreator
    public RegistrationUserDto(
            @JsonProperty("login") String login,
            @JsonProperty("password") String password,
            @JsonProperty("repeat_password") String repeatPassword,
            @JsonProperty("first_name") String name,
            @JsonProperty("last_name") String lastName,
            @JsonProperty("phone_number") String phoneNumber) {
        this.login = login;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
