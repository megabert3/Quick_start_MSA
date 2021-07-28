package ru.diasoft.micro.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.diasoft.micro.domain.SmsVerification;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class SmsVerificationRepositoryTest {

    @Autowired
    private SmsVerificationRepository smsVerificationRepository;

    private final String processGUID = "99999999999";
    private final String secretCode = "5555";
    private final String phoneNumber = "986784323212";

    private final SmsVerification smsVerification = SmsVerification.builder()
            .processGUID(processGUID)
            .secretCode(secretCode)
            .phoneNumber(phoneNumber)
            .status("WAITING")
            .build();

    @BeforeEach
    public void init(){
        smsVerificationRepository.save(smsVerification);
    }

    @AfterEach
    public void clear() {
        Optional<SmsVerification> smsVerification =
                smsVerificationRepository.findByProcessGUID_AndSecretCodeAndStatus(
                        processGUID, secretCode, phoneNumber);

        smsVerificationRepository.delete(smsVerification.get());
    }

    @Test
    void updateStatusByProcessGuid() {

        String newStatus = "OK";

        int value = smsVerificationRepository.updateStatusByProcessGuid(newStatus, processGUID);

        Optional<SmsVerification> smsVerification =
                smsVerificationRepository.findByProcessGUID_AndSecretCodeAndStatus(
                        processGUID, secretCode, phoneNumber);

        assertEquals(smsVerification.get().getStatus(), newStatus);
    }
}