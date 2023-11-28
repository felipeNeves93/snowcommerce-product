package com.sowcommerceproduct.adapter.messaging.event;

import com.sowcommerceproduct.adapter.messaging.dto.OrderDTO;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReceivedEvent {
    private String eventId;
    private OrderDTO order;
    private EventType eventType;
    private LocalDateTime timestamp;

}
