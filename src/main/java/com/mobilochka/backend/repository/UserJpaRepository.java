package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Product;
import com.mobilochka.backend.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface UserJpaRepository extends JpaRepository<Users, Integer> {

}


