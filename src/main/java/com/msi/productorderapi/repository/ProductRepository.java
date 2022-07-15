package com.msi.productorderapi.repository;

import com.msi.productorderapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    Product findProductById(Integer Id);
}
