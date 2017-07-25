package com.chumbok.pos.service;

import com.chumbok.pos.entity.Product;
import com.chumbok.pos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductServiceLive implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(long productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {

        if (productRepository.isProductExists(product.getBarcode())) {
            throw new IllegalArgumentException("Barcode already exists.");
        }

        productRepository.save(product);
        return product;
    }

    @Override
    public void updateProduct(Product product) {

        Product productById = getProduct(product.getId());

        productById.setDisplayName(product.getDisplayName());
        productById.setCatagory(product.getCatagory());
        productById.setBrand(product.getBrand());
        productById.setDescription(product.getDescription());
        productById.setWeight(product.getWeight());
        productById.setBarcode(product.getBarcode());

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long productId) {
        productRepository.delete(productId);
    }
}