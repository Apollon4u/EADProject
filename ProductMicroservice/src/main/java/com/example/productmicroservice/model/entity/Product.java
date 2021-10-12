package com.example.productmicroservice.model.entity;

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

    private String name;

    @Column(name = "is_active")
    private Boolean active;

    private Long quantity;
}
