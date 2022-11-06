package com.d3.media_luna.app.data.repository;

import com.d3.media_luna.app.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCodeSKU(String codeSKU);
}
