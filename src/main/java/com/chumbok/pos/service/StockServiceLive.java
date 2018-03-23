package com.chumbok.pos.service;

import com.chumbok.pos.dto.StockDTO;
import com.chumbok.pos.entity.Product;
import com.chumbok.pos.entity.Stock;
import com.chumbok.pos.repository.ProductRepository;
import com.chumbok.pos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StockServiceLive implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Stock getStock(long stockId) {
        return stockRepository.findOne(stockId);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock createStock(StockDTO stockDTO) {

        Stock stockById = new Stock();

        stockById.setPurchasePrice(stockDTO.getPurchasePrice());
        stockById.setSalePrice(stockDTO.getSalePrice());

        stockById.setStockEntryDate(stockDTO.getStockEntryDate());
        stockById.setStockExpireDate(stockDTO.getStockExpireDate());
        stockById.setQuantiy(stockDTO.getQuantiy());

        Product product = productRepository.findOne(stockDTO.getProductId());

        stockById.setProduct(product);

        stockRepository.save(stockById);
        return stockById;
    }

    @Override
    public void updateStock(Stock stock) {

        Stock stockById = getStock(stock.getId());

        stockById.setPurchasePrice(stock.getPurchasePrice());
        stockById.setSalePrice(stock.getSalePrice());

        stockById.setStockEntryDate(stock.getStockEntryDate());
        stockById.setStockExpireDate(stock.getStockExpireDate());
        stockById.setQuantiy(stock.getQuantiy());

        stockRepository.save(stockById);
    }

    @Override
    public void deleteStock(long stockId) {
        stockRepository.delete(stockId);
    }

    @Override
    public Long totalQuantityInStock(Long productId) {
        return stockRepository.totalQuantityInStock(productId);
    }
}
