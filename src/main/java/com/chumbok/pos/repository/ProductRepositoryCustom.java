package com.chumbok.pos.repository;

import com.chumbok.pos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryCustom {
    List<Product> getProductsWithStickQuantity();
}