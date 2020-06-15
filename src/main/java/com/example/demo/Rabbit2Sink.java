package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Rabbit2Sink {
    String RABBIT2_SUBSCRIPTION_CHANNEL = "rabbit2SubscriptionChannel";

    @Input
    SubscribableChannel rabbit2SubscriptionChannel();
}
