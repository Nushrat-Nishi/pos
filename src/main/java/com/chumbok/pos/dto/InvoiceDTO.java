package com.chumbok.pos.dto;

import java.util.Date;

public class InvoiceDTO {

    private Integer accountNumber;
    private Date invoiceDate;
    private Long InvoiceQuantiy;
    private Long productId;

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

    public Long getInvoiceQuantiy() {
        return InvoiceQuantiy;
    }

    public void setInvoiceQuantiy(Long invoiceQuantiy) {
        InvoiceQuantiy = invoiceQuantiy;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}