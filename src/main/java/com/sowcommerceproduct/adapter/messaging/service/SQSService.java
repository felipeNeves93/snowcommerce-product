package com.sowcommerceproduct.adapter.messaging.service;

import com.amazonaws.services.sqs.AmazonSQSClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SQSService {

    private final AmazonSQSClient client;

}
