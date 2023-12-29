#!/bin/sh

awslocal sqs create-queue --queue-name order-payment
awslocal sqs create-queue --queue-name order-finished

echo "Initialized."