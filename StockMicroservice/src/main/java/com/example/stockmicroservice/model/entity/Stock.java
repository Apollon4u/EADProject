package com.example.stockmicroservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "stock")
@FieldNameConstants
public class Stock {

    @Id
    @SequenceGenerator(name = "stock-sequence", sequenceName = "stock_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "stock-sequence")
    private Long id;

    @Type(type = "jsonb")
    private Address address;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "is_pickup_available")
    private Boolean pickupAvailable;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
