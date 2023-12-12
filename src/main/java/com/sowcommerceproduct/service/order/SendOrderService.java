package com.sowcommerceproduct.service.order;

import com.sowcommerceproduct.domain.order.Order;
import com.sowcommerceproduct.usecase.order.SendOrderUseCase;
import org.springframework.stereotype.Service;

@Service
public class SendOrderService implements SendOrderUseCase {

    @Override
    public void send(Order order) {

    }
}
