package com.d3.media_luna.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String codeSKU;
    private String description;
    private String category;
    private Double amount;
}
