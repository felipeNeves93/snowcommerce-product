package com.sowcommerceproduct.domain.order;

import lombok.Getter;

@Getter
public enum Status {
    PAYMENT_APPROVED(true, false),
    PAYMENT_REFUSED(false, true),
    OUT_OF_STOCK(false, false),
    WAITING_PAYMENT(true, false),
    ERROR(false, false);

    private final boolean removeProductFromStock;
    private final boolean addProductToStock;

    Status(boolean removeProductFromStock, boolean addProductToStock) {
        this.removeProductFromStock = removeProductFromStock;
        this.addProductToStock = addProductToStock;
    }
}
