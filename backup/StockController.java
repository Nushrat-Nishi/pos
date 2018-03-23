package com.chumbok.pos.controller;

import com.chumbok.pos.dto.PersistedObjId;
import com.chumbok.pos.dto.StockDTO;
import com.chumbok.pos.entity.Stock;
import com.chumbok.pos.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Stock> getStocks() {
        List<Stock> list = stockService.getAllStocks();
        return list;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public PersistedObjId createStock(@RequestBody @Valid StockDTO stockDTO) {

        Stock stock = stockService.createStock(stockDTO);
        return new PersistedObjId(stock.getId());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Stock getStockById(@PathVariable("id") Integer id) {
        Stock stock = stockService.getStock(id);
        return stock;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateStock(@PathVariable("id") Long id, @RequestBody @Valid Stock stock) {
        stock.setId(id);
        stockService.updateStock(stock);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteStock(@PathVariable("id") Long id) {
        stockService.deleteStock(id);
    }
}
