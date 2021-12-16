package com.mobilochka.backend.repository;


import com.mobilochka.backend.model.product.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface GroupJpaRepository extends JpaRepository<Group, Integer> {
    Group findByName(String name);

}

