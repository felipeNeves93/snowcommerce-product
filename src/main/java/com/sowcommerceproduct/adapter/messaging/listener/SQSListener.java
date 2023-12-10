package com.sowcommerceproduct.adapter.messaging.listener;

import com.sowcommerceproduct.adapter.mapper.OrderMapper;
import com.sowcommerceproduct.adapter.messaging.mapper.MessageMapper;
import com.sowcommerceproduct.usecase.order.ReceiveOrderUseCase;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SQSListener {

    private final MessageMapper messageMapper;
    private final OrderMapper orderMapper;
    private final ReceiveOrderUseCase receiveOrderUseCase;

    @SqsListener(queueNames = {"${app.config.messaging.queues.order-payment}", "${app.config.messaging.queues.order-finished}"})
    public void orderEventListener(String message) {
        try {
            log.info("Message received: {}. Mapping...", message);
            var event = messageMapper.mapToOrderReceivedEvent(message);
            log.info("Event mapped successfully {} ", event);

            log.info("Mapping order from Event");
            var order = orderMapper.fromDTO(event.getOrder());
            log.info("Order mapped successfully {}", order);

            receiveOrderUseCase.receive(order, event.getEventType().isRemoveProductFromStock());

        } catch (Exception e) {
            log.error("An error ocurred while processing the message. Error: {}", e.getMessage());
        }

    }

}
