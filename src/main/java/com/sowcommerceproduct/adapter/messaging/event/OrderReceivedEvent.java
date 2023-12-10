package com.sowcommerceproduct.adapter.messaging.event;

import com.sowcommerceproduct.adapter.messaging.dto.OrderDTO;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReceivedEvent extends BaseEvent {

    private OrderDTO order;
    private EventType eventType;

}
