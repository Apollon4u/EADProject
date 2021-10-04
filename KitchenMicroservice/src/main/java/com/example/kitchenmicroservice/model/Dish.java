package com.example.kitchenmicroservice.model;

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

    private String name;

    @ElementCollection
    private List<Long> productIds;

    private Double price;
}
