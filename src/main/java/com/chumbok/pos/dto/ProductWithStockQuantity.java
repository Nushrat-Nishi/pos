package com.chumbok.pos.dto;

import java.math.BigDecimal;

public class ProductWithStockQuantity {
    private Long id;
    private String displayName;
    private String vendor;
    private String catagory;
    private String brand;
    private String description;
    private BigDecimal weight;
    private String barcode;
    private Long quantiyInStock;

    public ProductWithStockQuantity(Long id, String displayName, String vendor, String catagory, String brand, String description, BigDecimal weight, String barcode, Long quantiyInStock) {
        this.id = id;
        this.displayName = displayName;
        this.vendor = vendor;
        this.catagory = catagory;
        this.brand = brand;
        this.description = description;
        this.weight = weight;
        this.barcode = barcode;
        this.quantiyInStock = quantiyInStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Long getQuantiyInStock() {
        return quantiyInStock;
    }

    public void setQuantiyInStock(Long quantiyInStock) {
        this.quantiyInStock = quantiyInStock;
    }
}
