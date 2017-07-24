package com.chumbok.pos.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date stockEntryDate;
    private Date stockExpireDate;

    private BigDecimal purchasePrice;
    private BigDecimal salePrice;


    private Long quantiy;

    @ManyToOne
    private Product product;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(Long quantiy) {
        this.quantiy = quantiy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stockEntryDate=" + stockEntryDate +
                ", stockExpireDate=" + stockExpireDate +
                ", purchasePrice=" + purchasePrice +
                ", salePrice=" + salePrice +
                ", quantiy=" + quantiy +
                ", product=" + product +
                '}';
    }
}