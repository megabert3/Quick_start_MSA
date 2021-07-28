package ru.diasoft.micro.producer;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.diasoft.micro.model.SmsDeliveredMessage;

import static ru.diasoft.micro.Channels.SMS_VERIFICATION_DELIVERED;

@Configuration
@MessagingGateway
public interface SmsAdapterMessagingGateway {

    @Gateway(requestChannel = SMS_VERIFICATION_DELIVERED)
    void smsVerificationDelivered(SmsDeliveredMessage message);
}