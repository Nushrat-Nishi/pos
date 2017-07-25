package com.chumbok.pos.service;

import com.chumbok.pos.dto.InvoiceDTO;
import com.chumbok.pos.dto.StockDTO;
import com.chumbok.pos.entity.Invoice;
import com.chumbok.pos.entity.Product;
import com.chumbok.pos.entity.Stock;
import com.chumbok.pos.repository.InvoiceRepository;
import com.chumbok.pos.repository.ProductRepository;
import com.chumbok.pos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
@Service
public class InvoiceServiceLive implements InvoiceService {
    @Autowired
    private StockService stockService;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    StockRepository stockRepository;

    @Override
    public Invoice getInvoice(long invoiceId) {
        return invoiceRepository.findOne(invoiceId);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice createInvoice(InvoiceDTO invoiceDTO) {

        Invoice invoice = new Invoice();

        Product product = productRepository.findOne(invoiceDTO.getProductId());
        Stock stock = stockRepository.findOne(invoiceDTO.getProductId());
        Long productId = product.getId();

        invoice.setAccountNumber(invoiceDTO.getAccountNumber());
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setUniquePrice(stock.getSalePrice());

        if (stockRepository.totalQuantityInStock(productId) < invoiceDTO.getInvoiceQuantiy()) {
            throw new IllegalArgumentException("Quantity not enough in stock. Enter less amount.");

        } else {
            invoice.setInvoiceQuantiy(invoiceDTO.getInvoiceQuantiy());

            StockDTO stockDTO = new StockDTO();

            Long bg1, bg2;
            bg1 = invoiceDTO.getInvoiceQuantiy();
            bg2 = -Math.abs(bg1);

            stockDTO.setStockEntryDate(stock.getStockEntryDate());
            stockDTO.setStockExpireDate(stock.getStockExpireDate());
            stockDTO.setQuantiy(bg2);
            stockDTO.setProductId(productId);
            stockDTO.setPurchasePrice(stock.getPurchasePrice());
            stockDTO.setSalePrice(stock.getSalePrice());

            stockService.createStock(stockDTO);
        }

        BigDecimal salePrice = stock.getSalePrice();
        BigDecimal invoiceQuantiy = new BigDecimal(invoiceDTO.getInvoiceQuantiy());
        BigDecimal totalPrice = BigDecimal.ZERO;
        totalPrice = totalPrice.add(salePrice.multiply(invoiceQuantiy));

        invoice.setTotalPrice(totalPrice);
        invoice.setStock(stock);

        invoiceRepository.save(invoice);

        return invoice;
    }

    @Override
    public void updateInvoice(Invoice invoice) {

        Invoice invoiceById = getInvoice(invoice.getId());

        invoiceById.setAccountNumber(invoice.getAccountNumber());

        invoiceById.setInvoiceDate(invoice.getInvoiceDate());
        invoiceById.setUniquePrice(invoice.getUniquePrice());
        invoiceById.setInvoiceQuantiy(invoice.getInvoiceQuantiy());

        BigDecimal salePrice = invoice.getUniquePrice();
        BigDecimal invoiceQuantiy = new BigDecimal(invoice.getInvoiceQuantiy());
        BigDecimal totalPrice = BigDecimal.ZERO;
        totalPrice = totalPrice.add(salePrice.multiply(invoiceQuantiy));

        invoiceById.setTotalPrice(totalPrice);

        invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(long invoiceId) {
        invoiceRepository.delete(invoiceId);
    }
}