package org.example.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserRequestDto {
    @JsonProperty("login")
    private final String login;
    @JsonProperty("first_name")
    private final String name;
    @JsonProperty("last_name")
    private final String lastName;
    @JsonProperty("phone_number")
    private final String phoneNumber;
    @JsonProperty("roles")
    private final List<String> roles;

    public UserRequestDto(String login, String name, String lastName, String phoneNumber, List<String> roles) {
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }
}
