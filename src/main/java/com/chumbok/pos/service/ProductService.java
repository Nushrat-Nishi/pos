package com.chumbok.pos.service;

import com.chumbok.pos.entity.Product;

import java.util.List;

/**
 * Created by Dell on 06-Jul-17.
 */
public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(long productId);

    Product createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(long productId);
}