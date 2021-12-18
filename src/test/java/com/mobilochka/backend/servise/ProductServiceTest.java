package com.mobilochka.backend.servise;

import com.mobilochka.backend.model.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;


@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void findByArticle() throws IOException {
        productService.findByArticle("683624");
    }

    @Test
    void getAll() {
        productService.getAll(0,5);
    }

    @Test
    void findByBarcode() {
        productService.findByBarcode("001007419598");
    }

    @Test
    void findAllNew() {
       productService.findAllNew();

    }

    @Test
    void findAllNewSmartfon() {
        List<Product> p= productService.findAllNewSmartfon();

    }


}