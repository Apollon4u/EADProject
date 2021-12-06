package com.example.productmicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "product")
@FieldNameConstants
public class Product {
    @Id
    @SequenceGenerator(name = "product-sequence", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "product-sequence")
    private Long id;

    @ApiModelProperty("Name of product")
    private String name;

    @Column(name = "is_active")
    @ApiModelProperty("Status of product for use")
    private Boolean active;

    @ApiModelProperty("Quantity of product in storage")
    private Long quantity;

    @ApiModelProperty(notes = "Price of product")
    private Double totalPrice;
}
