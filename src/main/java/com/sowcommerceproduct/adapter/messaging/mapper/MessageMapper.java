package com.sowcommerceproduct.adapter.messaging.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sowcommerceproduct.adapter.messaging.event.OrderReceivedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageMapper {

    private final ObjectMapper objectMapper;

    public OrderReceivedEvent mapToOrderReceivedEvent(String message) throws IllegalStateException {
        try {
            return objectMapper.readValue(message, OrderReceivedEvent.class);
        } catch (Exception e) {
            log.error("An exception occurred when processing the message: Error: {} Message: {}", e, message);
            throw new IllegalStateException(e);
        }
    }
}
