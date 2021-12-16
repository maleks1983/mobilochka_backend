package com.mobilochka.backend.servise;

import com.mobilochka.backend.model.product.Product;
import com.mobilochka.backend.repository.CatalogRepository;
import com.mobilochka.backend.repository.GroupRepository;
import com.mobilochka.backend.repository.ManufacturRepository;
import com.mobilochka.backend.repository.ProductRepository;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

    public Product findByArticle(String article) {
        return productRepository.findByArticle(article);
    }

    public Page<Product> getAll(int page, int size) {
        return productRepository.findAll(page, size);
    }

    public Product findByBarcode(String barcode) {
        return productRepository.findByBarcode(barcode);
    }

}


