package com.example.productcategorymicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "category", schema = "public")
public class Category {

    @Id
    @SequenceGenerator(name = "category-seq", sequenceName = "category_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "category-seq")
    private Long id;

    @ApiModelProperty("Category name")
    private String name;

    @ApiModelProperty("Category description")
    private String description;

    @ApiModelProperty("Category status")
    private boolean isEnabled;
}
