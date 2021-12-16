package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Category;
import com.mobilochka.backend.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;

@Transactional(readOnly = true)
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

    Product findByArticle(String article);


    Product findByBarcode(String barcode);


}
