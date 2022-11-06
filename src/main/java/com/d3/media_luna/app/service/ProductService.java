package com.d3.media_luna.app.service;

import com.d3.media_luna.app.data.dto.ProductDTO;
import com.d3.media_luna.app.data.mapper.ProductMapper;
import com.d3.media_luna.app.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
        mapper = new ProductMapper();
    }

    public ProductDTO save(ProductDTO productDTO){
        return mapper.toDTO(repository.save(mapper.toDomain(productDTO)));
    }

    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(String SKU) {
        return mapper.toDTO(repository.findByCodeSKU(SKU)
                .orElseThrow(() -> new RuntimeException("El articulo no existe")));
    }

    public ProductDTO update(ProductDTO productDTO) {
        return mapper.toDTO(repository.save(mapper.toDomain(productDTO)));
    }

    public ProductDTO delete(ProductDTO productDTO) {
        repository.delete(mapper.toDomain(productDTO));
        return productDTO;
    }
}
