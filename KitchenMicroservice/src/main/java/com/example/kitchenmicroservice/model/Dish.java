package com.example.kitchenmicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "dish")
@NoArgsConstructor
public class Dish {

    @Id
    @SequenceGenerator(name = "dish-sequence", sequenceName = "dish_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "dish-sequence")
    private Long id;

    @ApiModelProperty("Name of dish")
    private String name;

    @ElementCollection
    @ApiModelProperty("List of products contained in dish")
    private List<Long> productIds;

    @ApiModelProperty("Price of dish")
    private Double price;
}
