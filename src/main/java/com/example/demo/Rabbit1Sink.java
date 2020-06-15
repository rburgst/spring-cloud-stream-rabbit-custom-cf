package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Rabbit1Sink {
    String RABBIT1_SUBSCRIPTION_CHANNEL = "rabbit1SubscriptionChannel";

    @Input
    SubscribableChannel rabbit1SubscriptionChannel();
}
