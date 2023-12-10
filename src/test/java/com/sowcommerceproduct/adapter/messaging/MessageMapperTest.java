package com.sowcommerceproduct.adapter.messaging;

import com.sowcommerceproduct.FileTestManipulator;
import com.sowcommerceproduct.adapter.messaging.event.EventType;
import com.sowcommerceproduct.adapter.messaging.listener.SQSListener;
import com.sowcommerceproduct.adapter.messaging.mapper.MessageMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MessageMapperTest extends FileTestManipulator {

    @Autowired
    private MessageMapper messageMapper;

    @MockBean
    private SqsAsyncClient sqsAsyncClient;

    @MockBean
    private SQSListener sqsListener;

    @DisplayName("When mapping json message to object then should return mapped message")
    @Test
    void whenMappingOrderReceivedJsonMessageToObjectThenShouldReturnMappedMessage() throws IOException {
        var jsonFilePath = "events/order-event.json";
        var message = readFileAsString(jsonFilePath);

        var mappedMessage = messageMapper.mapToOrderReceivedEvent(message);

        final var expectedId = "4b8f5502-4702-4819-9fb7-884138d68c50";
        final var expectedProductsLength = 2;
        final var expectedOrderId = "844229fb-3445-4dfe-b616-c7766b60ce76";
        final var expectedTotal = 1800;
        final var expectedEventType = EventType.WAITING_PAYMENT;

        assertThat(mappedMessage.getEventId()).isEqualTo(expectedId);
        assertThat(mappedMessage.getOrder()).isNotNull();
        assertThat(mappedMessage.getOrder().getProducts()).hasSize(expectedProductsLength);
        assertThat(mappedMessage.getOrder().getId()).isEqualTo(expectedOrderId);
        assertThat(mappedMessage.getOrder().getTotal()).isEqualTo(expectedTotal);
        assertThat(mappedMessage.getEventType()).isEqualTo(expectedEventType);
    }
}
