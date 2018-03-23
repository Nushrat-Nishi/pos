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


}