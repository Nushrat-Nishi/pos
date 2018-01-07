package com.chumbok.pos.service;

import com.chumbok.pos.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(long productId);

    Product createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(long productId);

    List<Product> searchProduct(String displayName);
}