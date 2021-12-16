package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.users.Role;
import com.mobilochka.backend.model.users.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class UserRepositoryTest {

    public Users admin = new Users("Admin", "admin@mail.ru", "password", Set.of(Role.ROLE_ADMIN));

    @Autowired
    protected UserRepository repository;

    @Test
    void saveUser() {
        repository.saveUser(admin);
        Users u = repository.findById(100000);
        System.out.println(u.toString());

    }

}