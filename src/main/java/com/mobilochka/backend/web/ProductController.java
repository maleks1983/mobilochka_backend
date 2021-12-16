package com.mobilochka.backend.web;


import com.mobilochka.backend.model.product.Product;
import com.mobilochka.backend.servise.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Page<Product> products(@PathVariable int id) {
        Page<Product> pages = service.getAll(0, 30);
        return service.getAll(id, 30);

    }
}
