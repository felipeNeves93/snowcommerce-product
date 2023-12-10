package com.sowcommerceproduct.service.order;

import com.sowcommerceproduct.domain.order.Order;
import com.sowcommerceproduct.usecase.order.ReceiveOrderUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiveOrderService implements ReceiveOrderUseCase {

    @Override
    public void receive(Order order, boolean removeProductsFromStock) {
        log.info("Receiveing order: {}, Remove From Stock: {} ", order, removeProductsFromStock);
    }
}
