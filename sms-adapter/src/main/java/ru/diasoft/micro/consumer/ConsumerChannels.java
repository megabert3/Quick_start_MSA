package ru.diasoft.micro.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import ru.diasoft.micro.Channels;

public interface ConsumerChannels {

    @Input(Channels.SMS_VERIFICATION_MESSAGE)
    SubscribableChannel smsVerificationCreated();
}
