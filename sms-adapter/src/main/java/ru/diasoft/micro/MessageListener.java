package ru.diasoft.micro;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import ru.diasoft.micro.model.SmsDeliveredMessage;
import ru.diasoft.micro.model.SmsVerificationMessage;
import ru.diasoft.micro.producer.SmsAdapterMessagingGateway;

@RequiredArgsConstructor
@Configuration
public class MessageListener {
    private Logger logger = Logger.getLogger(MessageListener.class);

    private final SmsAdapterMessagingGateway gateway;

    @StreamListener(Channels.SMS_VERIFICATION_MESSAGE)
    public void smsVerificationCreated(SmsVerificationMessage message) {
        gateway.smsVerificationDelivered(
                SmsDeliveredMessage.builder().quid(message.getQuid()).build());
    }
}