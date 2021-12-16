//package com.mobilochka.backend.servise;
//
//import com.mobilochka.backend.model.product.Product;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ProductServiceTest {
//
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    void findByArticle() throws IOException {
//       productService.findByArticle("683624");
//    }
//
//    @Test
//    void getAll() {
//        List<Product>products = productService.getAll();
//        System.out.println(products);
//    }
//
//    @Test
//    void findByBarcode() {
//        Product p = productService.findByBarcode("001007419598");
//        System.out.println(p);
//    }
//}