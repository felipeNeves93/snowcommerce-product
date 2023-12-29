package com.sowcommerceproduct.adapter.messaging.listener;

import com.sowcommerceproduct.FileTestManipulator;
import com.sowcommerceproduct.adapter.mapper.OrderMapper;
import com.sowcommerceproduct.adapter.messaging.mapper.MessageMapper;
import com.sowcommerceproduct.usecase.order.ProcessOrderUseCase;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.test.sqs.SqsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.util.Map;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.SQS;

@SqsTest(SQSListener.class)
@Testcontainers
class SqsListenerTest extends FileTestManipulator {

    @Container
    static LocalStackContainer localStack =
            new LocalStackContainer(DockerImageName.parse("localstack/localstack:0.14.3"))
                    .withClasspathResourceMapping("/localstack", "/docker-entrypoint-initaws.d", BindMode.READ_ONLY)
                    .withServices(LocalStackContainer.Service.SQS)
                    .waitingFor(Wait.forLogMessage(".*Initialized\\.\n", 1));

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("cloud.aws.sqs.endpoint", () -> localStack.getEndpointOverride(SQS).toString());
        registry.add("cloud.aws.credentials.access-key", () -> "foo");
        registry.add("cloud.aws.credentials.secret-key", () -> "bar");
        registry.add("cloud.aws.region.static", () -> localStack.getRegion());
        registry.add("app.config.messaging.queues.order-payment", () -> "order-payment");
        registry.add("app.config.messaging.queues.order-finished", () -> "order-finished");
    }

    @Autowired
    private SqsTemplate sqsTemplate;

    @MockBean
    private MessageMapper messageMapper;

    @MockBean
    private OrderMapper orderMapper;

    @MockBean
    private ProcessOrderUseCase processOrderUseCase;

    @DisplayName("Should process incoming message on queue order-payment")
    @Test
    void shouldProccessIncomingMessageOnQueueOrderPayment() throws IOException {
        final var queueName = "order-payment";
        var messageHeaders = Map.of("contentType", "application/json");
        var jsonFilePath = "events/order-event.json";

        var payload = readFileAsString(jsonFilePath);

        sqsTemplate.send(queueName, new GenericMessage<>(payload));
    }
}
