package com.sowcommerceproduct.adapter.messaging.event;

import lombok.Getter;

@Getter
public enum EventType {
    PAYMENT_APPROVED(true),
    PAYMENT_REFUSED(false),
    OUT_OF_STOCK(false),
    WAITING_PAYMENT(true);

    private boolean removeProductFromStock;

    EventType(boolean removeProductFromStock) {
        this.removeProductFromStock = removeProductFromStock;
    }
}
