package com.example.ordermicroservice.model.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("Айди прикрепленного юзера")
    private String userId;

    @Column(name = "date_created")
    @ApiModelProperty("Дата создания заказа")
    private Timestamp dateCreated;

    @ElementCollection
    @ApiModelProperty("Айди блюд находящихся в заказе")
    private List<Long> dishIds;

    @Column(name = "total_price")
    @ApiModelProperty("Цена за заказ")
    private Double totalPrice;
}
