package com.chumbok.pos.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Stock stock;

    @Min(value = 1)
    private Long invoiceQuantiy;

    @Min(value = 0)
    @NotNull
    private BigDecimal uniquePrice;

    @Min(value = 0)
    @NotNull
    private BigDecimal totalPrice;

    @Min(value = 0)
    @NotNull
    private Integer accountNumber;

    @NotNull
    private Date invoiceDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Long getInvoiceQuantiy() {
        return invoiceQuantiy;
    }

    public void setInvoiceQuantiy(Long invoiceQuantiy) {
        this.invoiceQuantiy = invoiceQuantiy;
    }

    public BigDecimal getUniquePrice() {
        return uniquePrice;
    }

    public void setUniquePrice(BigDecimal uniquePrice) {
        this.uniquePrice = uniquePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", stock=" + stock +
                ", invoiceQuantiy=" + invoiceQuantiy +
                ", uniquePrice=" + uniquePrice +
                ", totalPrice=" + totalPrice +
                ", accountNumber=" + accountNumber +
                ", invoiceDate=" + invoiceDate +
                '}';
    }
}