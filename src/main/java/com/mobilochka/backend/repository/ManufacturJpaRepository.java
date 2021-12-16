package com.mobilochka.backend.repository;


import com.mobilochka.backend.model.product.Group;
import com.mobilochka.backend.model.product.Manufactur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ManufacturJpaRepository extends JpaRepository<Manufactur, Integer> {
    Manufactur findByName(String name);

}
