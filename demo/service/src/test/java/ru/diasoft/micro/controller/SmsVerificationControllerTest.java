package ru.diasoft.micro.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.diasoft.micro.domain.SmsVerification;
import ru.diasoft.micro.repository.SmsVerificationRepository;

import java.util.UUID;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SmsVerificationControllerTest {

    private static final String PHONE_NUMBER = "123456789";
    private static final String VALID_SECRET_CODE = "1537";
    private static final String INVALID_SECRET_CODE = "4444";
    private static final String GUID = UUID.randomUUID().toString();

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SmsVerificationRepository smsVerificationRepository;

    @Before
    public void init() {
        smsVerificationRepository.deleteAll();
    }

    @Test
    public void checkValidCodeResultTrue() throws Exception {
        smsVerificationRepository.deleteAll();

        SmsVerification smsVerification = SmsVerification.builder()
                .phoneNumber(PHONE_NUMBER)
                .secretCode(VALID_SECRET_CODE)
                .processGUID(GUID)
                .status("OK")
                .build();

        smsVerificationRepository.save(smsVerification);

        this.mockMvc.perform(get("/v1/sms-verification?Code=" + VALID_SECRET_CODE + "&ProcessGUID=" + GUID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    public void checkValidCodeResultFalse() throws Exception {

        smsVerificationRepository.deleteAll();

        SmsVerification smsVerification = SmsVerification.builder()
                .phoneNumber(PHONE_NUMBER)
                .secretCode(VALID_SECRET_CODE)
                .processGUID(GUID)
                .status("WAITING")
                .build();

        smsVerificationRepository.save(smsVerification);

        this.mockMvc.perform(get("/v1/sms-verification?Code=" + VALID_SECRET_CODE + "&ProcessGUID=" + GUID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));
    }

    @Test
    public void checkInvalidCodeResultFalse() throws Exception {

        smsVerificationRepository.deleteAll();

        SmsVerification smsVerification = SmsVerification.builder()
                .phoneNumber(PHONE_NUMBER)
                .secretCode(VALID_SECRET_CODE)
                .processGUID(GUID)
                .status("OK")
                .build();

        smsVerificationRepository.save(smsVerification);

        this.mockMvc.perform(get("/v1/sms-verification?Code=" + INVALID_SECRET_CODE + "&ProcessGUID=" + GUID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));
    }
}