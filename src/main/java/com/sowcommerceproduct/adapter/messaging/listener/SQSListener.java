package com.sowcommerceproduct.adapter.messaging.listener;

import com.sowcommerceproduct.adapter.messaging.mapper.MessageMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SQSListener {

    private final MessageMapper messageMapper;

    @SqsListener(queueNames = {"${app.config.messaging.queues.order-payment}", "${app.config.messaging.queues.order-finished}"})
    public void orderEventListener(String message) {
        try {
            log.info("Message received: {}. Mapping...", message);
            var event = messageMapper.mapToOrderReceivedEvent(message);
            log.info("Mapped successfully {} ", event);
        } catch (Exception e) {
            log.error("An error ocurred while processing the message. Error: {}", e.getMessage());
        }

    }

}
