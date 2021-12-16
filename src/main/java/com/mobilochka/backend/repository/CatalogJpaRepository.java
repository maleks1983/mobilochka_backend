package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CatalogJpaRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);


}
