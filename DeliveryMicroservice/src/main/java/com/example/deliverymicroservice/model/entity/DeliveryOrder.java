package com.example.deliverymicroservice.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "delivery_order")
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("id of attached order")
    private Long orderId;

    @ApiModelProperty("Delivery's tracking number")
    private String trackingNumber;

    @ApiModelProperty("Address of user")
    private String address;

    @ApiModelProperty("Created time")
    private LocalDateTime createdAt;
}
