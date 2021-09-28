package com.example.ordermicroservice.model.entity;

import com.example.ordermicroservice.model.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@FieldNameConstants
public class Order {

    @Id
    @SequenceGenerator(name = "order-sequence", sequenceName = "order_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "order-sequence")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "total_price")
    private Integer totalPrice;
}
