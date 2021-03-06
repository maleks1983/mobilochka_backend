package com.mobilochka.backend.servise;


import com.mobilochka.backend.model.product.Category;
import com.mobilochka.backend.repository.CatalogRepository;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class CategoryService {

    private final CatalogRepository repository;

    public CategoryService(CatalogRepository repository) {
        this.repository = repository;
    }

    public void save(Category product) {
        repository.save(product);
    }

    public Category findById(int id) {
        return repository.findById(id);
    }


}

