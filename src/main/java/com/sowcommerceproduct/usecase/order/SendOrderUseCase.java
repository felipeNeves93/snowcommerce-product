package com.sowcommerceproduct.usecase.order;

import com.sowcommerceproduct.domain.order.Order;
import com.sowcommerceproduct.domain.order.Status;

public interface SendOrderUseCase {

    void send(Order order, Status status);
}
