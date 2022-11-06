package com.d3.media_luna.app.controller;

import com.d3.media_luna.app.data.dto.ProductDTO;
import com.d3.media_luna.app.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO product){
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getBySKU(@PathVariable String SKU) {
        return ResponseEntity.ok(service.findById(SKU));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(service.update(product));
    }

    @DeleteMapping()
    public ResponseEntity<ProductDTO> delete(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(service.delete(product));
    }
}
