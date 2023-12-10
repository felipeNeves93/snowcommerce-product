package com.sowcommerceproduct.usecase.order;

import com.sowcommerceproduct.domain.order.Order;

public interface ReceiveOrderUseCase {

    void receive(Order order, boolean removeProductsFromStock);
}
