package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public class ProductRepository {

    private final ProductJpaRepository repository;

    public ProductRepository(ProductJpaRepository repository) {
        this.repository = repository;
    }


    public void save(Product product) {
        repository.save(product);
    }

    public Product findByArticle(String article) {
        return repository.findByArticle(article);
    }

    public Page<Product> findAll(int page, int size) {
        Pageable sortedByName = PageRequest.of(page, size, Sort.by("name"));
        return repository.findAll(sortedByName);
    }


    public Product findByBarcode(String barcode) {
        return repository.findByBarcode(barcode);
    }

    public List<Product> findAllNew(){
        Pageable sortedByArticle = PageRequest.of(0, 10, Sort.by("id").descending());
        return repository.findAll(sortedByArticle).getContent();
    }
}

