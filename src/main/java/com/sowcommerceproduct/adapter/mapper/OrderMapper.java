package com.sowcommerceproduct.adapter.mapper;

import com.sowcommerceproduct.adapter.messaging.dto.OrderDTO;
import com.sowcommerceproduct.domain.order.Order;
import com.sowcommerceproduct.domain.order.OrderProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderMapper implements Mapper<OrderDTO, Order, Object> {

    private static final String MESSAGE_NOT_IMPLEMENTED = "Method not implemented!";

    @Override
    public Order fromEntity(Object entity) {
        throw new IllegalStateException(MESSAGE_NOT_IMPLEMENTED);
    }

    @Override
    public Order fromDTO(OrderDTO dto) {
        final var mappedProducts = new ArrayList<OrderProduct>();

        dto.getProducts().forEach(p -> mappedProducts.add(OrderProduct.builder()
                .id(p.id())
                .price(p.price())
                .amount(p.amount())
                .build()));

        return Order.builder()
                .id(dto.getId())
                .total(dto.getTotal())
                .products(mappedProducts)
                .build();
    }

    @Override
    public Object toEntity(Order domain) {
        throw new IllegalStateException(MESSAGE_NOT_IMPLEMENTED);
    }

    @Override
    public OrderDTO toDTO(Order domain) {
        throw new IllegalStateException(MESSAGE_NOT_IMPLEMENTED);
    }
}
