package com.chumbok.pos.dto;

import java.math.BigDecimal;
import java.util.Date;


public class StockDTO {
    private Date stockEntryDate;
    private Date stockExpireDate;
    private Long quantiy;
    private Long productId;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;

    public Date getStockEntryDate() {
        return stockEntryDate;
    }

    public void setStockEntryDate(Date stockEntryDate) {
        this.stockEntryDate = stockEntryDate;
    }

    public Date getStockExpireDate() {
        return stockExpireDate;
    }

    public void setStockExpireDate(Date stockExpireDate) {
        this.stockExpireDate = stockExpireDate;
    }

    public Long getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(Long quantiy) {
        this.quantiy = quantiy;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}