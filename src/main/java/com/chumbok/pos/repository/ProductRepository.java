package com.chumbok.pos.repository;

import com.chumbok.pos.dto.ProductWithStockQuantity;
import com.chumbok.pos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT COUNT(p) > 0 FROM Product p WHERE barcode = ?")
    boolean isProductExists(String barcode);

    @Query("SELECT p FROM Product p WHERE p.displayName LIKE %?1%")
    List<Product> findProductsByDisplayName(String displayName);

    @Query("delete from Product p where p.id in ?1")
      void deleteBulkProduct(List<Long> ids);


    @Query("SELECT new com.chumbok.pos.dto.ProductWithStockQuantity(p.id, p.displayName, p.vendor, p.catagory, p.brand, p.description, p.weight, p.barcode, SUM(s.quantiy)) FROM Stock s " +
            "RIGHT JOIN s.product p " +
            "GROUP BY p.id")
    List<ProductWithStockQuantity> productStock();

}