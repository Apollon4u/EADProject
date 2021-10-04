package com.example.ordermicroservice.model.entity;

import com.example.ordermicroservice.model.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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

    @ElementCollection
    private List<Long> dishIds;

    @Column(name = "total_price")
    private Double totalPrice;
}
