package com.example.ratingmicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "rating")
public class Rating {
    @Id
    @SequenceGenerator(name = "rating-sequence", sequenceName = "rating_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "rating-sequence")
    private Long id;

    @ApiModelProperty("Name of product")
    private String comment;

    @ApiModelProperty("Mark from user for kitchen")
    private Double mark;

    @ApiModelProperty("User's id")
    private Long userId;

    @ApiModelProperty("Rated kitchen's id")
    private Long kitchenId;
}
