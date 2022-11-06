package com.d3.media_luna.app.data.mapper;

import com.d3.media_luna.app.data.dto.ProductDTO;
import com.d3.media_luna.app.data.model.Product;

public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getCodeSKU(),
                product.getDescription(),
                product.getCategory(),
                product.getAmount()
        );
    }

    public Product toDomain(ProductDTO productDTO) {
        return new Product(
                productDTO.getId(),
                productDTO.getCodeSKU(),
                productDTO.getDescription(),
                productDTO.getCategory(),
                productDTO.getAmount()
        );
    }
}
