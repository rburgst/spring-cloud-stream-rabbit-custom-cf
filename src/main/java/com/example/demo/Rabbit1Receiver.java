package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Rabbit1Receiver {
    @StreamListener(Rabbit1Sink.RABBIT1_SUBSCRIPTION_CHANNEL)
    public void handleMessage(@Payload String payload) {
        log.info("received rabbit1 {}", payload);
    }
}
