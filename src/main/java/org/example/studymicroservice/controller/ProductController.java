package org.example.studymicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.studymicroservice.entity.Product;
import org.example.studymicroservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repo;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}/decrease")
    public Product decrease(@PathVariable Integer id, @RequestParam Integer quantity) {
        Product p = repo.findById(id).orElseThrow();
        p.setStock(p.getStock() - quantity);
        return repo.save(p);
    }
}
