package com.sowcommerceproduct.adapter.messaging.event;

import com.sowcommerceproduct.adapter.dto.OrderDTO;

public class OrderReceivedEvent {
    private OrderDTO order;
    private EventType eventType;

}
