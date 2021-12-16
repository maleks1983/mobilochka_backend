package com.mobilochka.backend.web;


import com.mobilochka.backend.model.product.Product;
import com.mobilochka.backend.servise.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/products")
public class Controller {

    private final ProductService service;

    public Controller(ProductService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Page<Product> products(@PathVariable int id) {
        Page<Product> pages = service.getAll(0, 30);
        return service.getAll(id, 30);

    }
}
