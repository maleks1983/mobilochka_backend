package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


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
        Pageable sortedByArticle = PageRequest.of(0, 12, Sort.by("id").descending());
        return repository.findAll(sortedByArticle).getContent();
    }
    public List<Product> findAllNewSmartfon(){
        return entityManager.createQuery("SELECT p FROM Product p  where p.category.name =: name ORDER BY p.id desc ",
                Product.class).setParameter("name", "Смартфоны").setMaxResults(12).getResultList();
    }
}

