package com.example.ordermicroservice.model.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATED(0, "Новый заказ"),
    PAID(1, "Заказ оплачен"),
    APPROVED(2, "Заказ принят"),
    DELIVERY(3, "Заказ передан курьеру"),
    WAIT_PICKUP(4, "Ожидает самовывоза"),
    COMPLETED(5, "Заказ завершен"),
    CANCELLED(6, "Заказ отменен"),
    FAILED(7, "Оплата не прошла");

    private final Integer index;
    private final String name;

    OrderStatus(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
