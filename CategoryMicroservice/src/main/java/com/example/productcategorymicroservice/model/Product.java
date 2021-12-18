package com.example.productcategorymicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    @ApiModelProperty("Id")
    private Long id;
    @ApiModelProperty("Name of product")
    private String name;
    @ApiModelProperty("Status of product for use")
    private Boolean active;
    @ApiModelProperty("Quantity of product in storage")
    private Long quantity;
    @ApiModelProperty("Total price of product")
    private Double totalPrice;
    @ApiModelProperty("Partner kitchen's id")
    private Long kitchenId;
    @ApiModelProperty("Product's category id")
    private Long categoryId;
}
