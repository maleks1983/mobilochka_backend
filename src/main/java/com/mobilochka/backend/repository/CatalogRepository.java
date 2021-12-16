package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CatalogRepository {

    private final CatalogJpaRepository repository;


    public CatalogRepository(CatalogJpaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Category save(Category category) {
        return repository.save(category);
    }

    @Transactional
    public Category saveByName(String name) {
        Category category = repository.findByName(name);
        if (category == null) {
            category = repository.save(new Category(name));
        }
        return category;

    }


    public Category findById(int id) {
        return repository.findById(id).orElse(null);
    }


    public Category findByName(String name) {
        return repository.findByName(name);
    }
}

