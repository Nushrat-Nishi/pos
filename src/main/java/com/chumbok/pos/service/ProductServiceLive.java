package com.chumbok.pos.service;

import com.chumbok.pos.dto.ProductWithStockQuantity;
import com.chumbok.pos.entity.Product;
import com.chumbok.pos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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


   /* public Product findByPagination(Long id){

            List<Product> products =  productRepository.findProductsByPagination(id, new PageRequest(0, 3, Sort.Direction.ASC, "id"));


return product;
    }*/

   public Page<Product> findAllByPage(Pageable pageable){
       Page<Product> products =  productRepository.findAll(pageable);
       return products;
    }

   @Override
    public Page<ProductWithStockQuantity> findProductWithStockQuantityByPage(Pageable pageable) {

       List<ProductWithStockQuantity> list= productRepository.productStock();

        System.out.println("nishi test 1 : "+list);

        Page<ProductWithStockQuantity> pageProductListWithStockQuantity  = new PageImpl<>(list);
       System.out.println("nishi test 2 : "+pageProductListWithStockQuantity);

        return pageProductListWithStockQuantity;
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
        productById.setVendor(product.getVendor());
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

    @Override
    public void deleteBulkProduct(List<Long> ids) {
        productRepository.deleteBulkProduct(ids);
    }

    @Override
    public List<Product> searchProduct(String displayName) {
        return  productRepository.findProductsByDisplayName(displayName);
    }
}