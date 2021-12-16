package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {
    @Autowired
    private UserJpaRepository repository;

    @Transactional
    public Users saveUser(Users user) {
        return repository.save(user);

    }

    public Users findById(int id) {
        return repository.findById(id).orElse(null);
    }


}

