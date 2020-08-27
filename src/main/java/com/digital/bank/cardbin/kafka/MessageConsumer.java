package com.digital.bank.cardbin.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ushaheu
 * @date 8/27/20 6:13 PM
 * @project card-bin-verification-service
 */
public interface MessageConsumer {

    @Input("input")
    SubscribableChannel input();
}
