package com.chumbok.pos.controller;

import com.chumbok.pos.dto.StockDTO;
import com.chumbok.pos.entity.Stock;
import com.chumbok.pos.service.ProductService;
import com.chumbok.pos.service.StockService;
import com.chumbok.pos.utility.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.ParseException;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/addStock", method = RequestMethod.GET)
    public ModelAndView showAddStockForm(@RequestParam(required = false) Long productId) throws Exception{

        ModelAndView modelAndView = new ModelAndView();

        if (productId != null) {
            /*Stock stock = stockService.getStock(productId);
            stock.getProduct();*/

            StockDTO stockDTO = new StockDTO();
            stockDTO.setProductId(productId);

            /*stockDTO.setPurchasePrice(stock.getPurchasePrice()*//*BigDecimal.valueOf(10).movePointLeft(2)*//*);
            stockDTO.setSalePrice(stock.getSalePrice()*//*BigDecimal.valueOf(10).movePointLeft(2)*//*);
            stockDTO.setQuantiy(stock.getQuantiy()*//*10l*//*);
            stockDTO.setStockEntryDate(stock.getStockEntryDate()*//*new DateConversion().stringToDate("23/07/1989")*//*);
            stockDTO.setStockExpireDate(stock.getStockExpireDate()*//*new DateConversion().stringToDate("12/12/1991")*//*);*/

            modelAndView.addObject("stockDTO", stockDTO);
        } else {
            modelAndView.addObject("stockDTO", new StockDTO());
        }

        modelAndView.setViewName("addStock");

        return modelAndView;
    }

    @RequestMapping(path = "/addStock", method = RequestMethod.POST)
    public ModelAndView createUpdateStock(@Valid StockDTO stockDTO) {
        System.out.println("Nishi Post.");

        ModelAndView modelAndView = new ModelAndView();

        stockService.createStock(stockDTO);

        modelAndView.addObject("successMessage", "Stock has been updated successfully");

        modelAndView.addObject("stockDTO", new StockDTO());
        modelAndView.setViewName("addStock");
        return modelAndView;

    }

    /*@ResponseStatus(value = HttpStatus.OK)
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
    }*/
}
