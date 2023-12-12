package com.sowcommerceproduct.usecase.order;

import com.sowcommerceproduct.domain.order.Order;

public interface SendOrderUseCase {

    void send(Order order);
}
