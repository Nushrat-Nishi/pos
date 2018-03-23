package com.chumbok.pos.service;

import com.chumbok.pos.dto.StockDTO;
import com.chumbok.pos.entity.Stock;

import java.util.List;

public interface StockService {

    List<Stock> getAllStocks();

    Stock getStock(long stockId);

    Stock createStock(StockDTO stockDTO);

    void updateStock(Stock stock);

    void deleteStock(long stockId);

    Long totalQuantityInStock(Long productId);


}
