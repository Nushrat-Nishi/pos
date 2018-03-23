package com.chumbok.pos.repository;

import com.chumbok.pos.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    @Query("SELECT COUNT(p) > 0 FROM Product p WHERE barcode = ?")
    boolean isProductExists(String barcode);

    @Query("SELECT p FROM Product p WHERE p.displayName LIKE %?1%")
    List<Product> findProductsByDisplayName(String displayName);

    @Query("delete from Product p where p.id in ?1")
      void deleteBulkProduct(List<Long> ids);

}