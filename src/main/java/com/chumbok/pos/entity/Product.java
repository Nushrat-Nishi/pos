package com.chumbok.pos.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
@Data
public class Product {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String displayName;
    private String vendor;
    private String catagory;
    private String brand;
    private String description;
    @Min(value = 0)
    private BigDecimal weight;
    //@Column(unique = true)
    @NotNull(message = "Barcode cannot be null")
    @NotEmpty(message = "Barcode cannot be empty")
    private String barcode;

    /*  public Long getId() {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", catagory='" + catagory + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", barcode='" + barcode + '\'' +
                '}';
    }*/
}