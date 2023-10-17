package org.example.repositories;

import io.github.yashchenkon.assertsqlcount.test.AssertSqlQueriesCount;
import org.example.common.TestDataGenerator;
import org.example.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource("/application-test.properties")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = TestDataGenerator.generateUser();
        testEntityManager.persistAndFlush(testUser);
        AssertSqlQueriesCount.reset();
    }

    @Test
    @DisplayName("find user by login if exists")
    public void findByLoginTest_IfExists() {
        Optional<User> userOp = userRepository.findByLogin(testUser.getLogin());
        User user = userOp.orElse(null);
        assertThat(user).isNotNull();
        assertEquals(user, testUser);
        System.out.println(user.getRoles());
        AssertSqlQueriesCount.assertSelectCount(1);
    }

    @Test
    @DisplayName("find user by login if not exists")
    public void findByLoginTest_IfNotExists() {
        Optional<User> user = userRepository.findByLogin(testUser.getLogin() + "1");
        assertThat(user.orElse(null)).isNull();
        AssertSqlQueriesCount.assertSelectCount(1);
    }
}