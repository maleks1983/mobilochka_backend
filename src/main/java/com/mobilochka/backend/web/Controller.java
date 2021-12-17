package com.mobilochka.backend.web;

import com.mobilochka.backend.model.product.Product;
import com.mobilochka.backend.servise.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final ProductService service;

    public Controller(ProductService service) {
        this.service = service;
    }


    @CrossOrigin
    @GetMapping("/newProducts")
    public List<Product> newProducts() {
        return service.findAllNewSmartfon();

    }


}
