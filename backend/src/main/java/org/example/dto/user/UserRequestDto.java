package org.example.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

    public UserRequestDto(String login, String name, String lastName, String phoneNumber) {
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
