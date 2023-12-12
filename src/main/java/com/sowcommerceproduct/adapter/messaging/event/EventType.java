package com.sowcommerceproduct.adapter.messaging.event;

import lombok.Getter;

@Getter
public enum EventType {
    PAYMENT_APPROVED,
    PAYMENT_REFUSED,
    OUT_OF_STOCK,
    WAITING_PAYMENT,
    ERROR;

}
