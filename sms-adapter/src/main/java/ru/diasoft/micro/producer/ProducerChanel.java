package ru.diasoft.micro.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import ru.diasoft.micro.Channels;

public interface ProducerChanel {
    @Output(Channels.SMS_VERIFICATION_DELIVERED)
    MessageChannel smsVerificationDelivered();
}
