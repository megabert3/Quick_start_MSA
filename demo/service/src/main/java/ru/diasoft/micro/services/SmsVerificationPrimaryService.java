package ru.diasoft.micro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.domain.SmsVerification;
import ru.diasoft.micro.domain.generated.SmsVerificationCheckRequest;
import ru.diasoft.micro.domain.generated.SmsVerificationCheckResponse;
import ru.diasoft.micro.domain.generated.SmsVerificationPostRequest;
import ru.diasoft.micro.domain.generated.SmsVerificationPostResponse;
import ru.diasoft.micro.model.SmsVerificationMessage;
import ru.diasoft.micro.repository.SmsVerificationRepository;
import ru.diasoft.micro.smsverificationmessage.publish.SmsVerificationMessagePublishGateway;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Primary
@Service
public class SmsVerificationPrimaryService implements SmsVerificationService {

    private final SmsVerificationRepository smsVerificationRepository;
    private final SmsVerificationMessagePublishGateway smsVerificationMessagePublishGateway;

    @Autowired
    public SmsVerificationPrimaryService(SmsVerificationRepository smsVerificationRepository, SmsVerificationMessagePublishGateway smsVerificationMessagePublishGateway) {
        this.smsVerificationRepository = smsVerificationRepository;
        this.smsVerificationMessagePublishGateway = smsVerificationMessagePublishGateway;
    }

    @Override
    public SmsVerificationCheckResponse dsSmsVerificationCheck(SmsVerificationCheckRequest smsVerificationCheckRequest) {

        Optional<SmsVerification> smsVerification = smsVerificationRepository.findByProcessGUID_AndSecretCodeAndStatus(
                smsVerificationCheckRequest.getProcessGUID(),
                smsVerificationCheckRequest.getCode(),
                "OK");

        return SmsVerificationCheckResponse.builder().
               checkResult(smsVerification.isPresent()).
               build();
    }

    @Override
    public SmsVerificationPostResponse dsSmsVerificationCreate(SmsVerificationPostRequest smsVerificationPostRequest) {

        String quid = UUID.randomUUID().toString();
        String secretCode = String.format("%04d", new Random().nextInt(100000));

        SmsVerification smsVerification = SmsVerification.builder()
                .phoneNumber(smsVerificationPostRequest.getPhoneNumber())
                .processGUID(quid)
                .secretCode(secretCode)
                .status("WAITING").build();

        smsVerificationRepository.save(smsVerification);

        smsVerificationMessagePublishGateway.smsVerificationMessage(
                SmsVerificationMessage.builder()
                        .quid(quid)
                        .build());

        return SmsVerificationPostResponse.builder().processGUID(quid).build();
    }
}
