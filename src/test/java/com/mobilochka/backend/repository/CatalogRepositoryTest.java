package com.mobilochka.backend.repository;


import com.mobilochka.backend.model.product.Category;
import com.mobilochka.backend.servise.CategoryServise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class CatalogRepositoryTest {

    @Autowired
    private CategoryServise catalogRepository;

//
//    @Test
//    void save() {
//        catalogRepository.save(new Category("Автотовары"));
//    }
//
//    @Test
//    void saveWirhParrent() {
//        catalogRepository.save(new Category("АЗУ"));
//    }
//
//    @Test
//    void findById() {
//        System.out.println(catalogRepository.findById(100001));
//    }


}