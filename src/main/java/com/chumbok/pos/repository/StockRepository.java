package com.chumbok.pos.repository;

import com.chumbok.pos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT SUM(quantiy) FROM Stock WHERE product_Id = ?")
    Long totalQuantityInStock(Long productId);
}