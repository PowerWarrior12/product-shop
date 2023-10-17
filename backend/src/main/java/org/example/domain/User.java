package org.example.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Role;

import java.util.List;

import static org.example.domain.User.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
@EqualsAndHashCode
public class User {
    @Id
    @Column(name = LOGIN_COLUMN_NAME)
    private String login;
    @Column(name = PASSWORD_COLUMN_NAME)
    private String password;
    @Column(name = NAME_COLUMN_NAME)
    private String name;
    @Column(name = LAST_NAME_COLUMN_NAME)
    private String lastName;
    @Column(name = PHONE_NUMBER_COLUMN_NAME)
    private String phoneNumber;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = USER_ROLE_TABLE_NAME, joinColumns = @JoinColumn(name = USER_ROLE_FOREIGN_KEY_NAME))
    @Enumerated(EnumType.STRING)
    @Column(name = USER_ROLE_ROLE_COLUMN_NAME)
    private List<Role> roles;
    // region constants
    public static final String TABLE_NAME = "shop_user";
    public static final String LOGIN_COLUMN_NAME = "login";
    public static final String PASSWORD_COLUMN_NAME = "password";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String LAST_NAME_COLUMN_NAME = "last_name";
    public static final String PHONE_NUMBER_COLUMN_NAME = "phone_number";
    public static final String USER_ROLE_TABLE_NAME = "user_role";
    public static final String USER_ROLE_FOREIGN_KEY_NAME = "login";
    public static final String USER_ROLE_ROLE_COLUMN_NAME = "role_name";
    // endregion
}
