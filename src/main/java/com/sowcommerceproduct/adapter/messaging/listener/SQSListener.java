package com.sowcommerceproduct.adapter.messaging.listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SQSListener {


    @SqsListener(queueNames = {"#{app.config.messaging.queues.order-payment}", "#{app.config.messaging.queues.order-finished}"})
    public void orderEventListener() {

    }

}
