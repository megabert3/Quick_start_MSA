/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.services;

import lombok.Generated;
import org.springframework.stereotype.Component;
import ru.diasoft.micro.domain.generated.SmsVerificationCheckRequest;
import ru.diasoft.micro.domain.generated.SmsVerificationCheckResponse;
import ru.diasoft.micro.domain.generated.SmsVerificationPostRequest;
import ru.diasoft.micro.domain.generated.SmsVerificationPostResponse;

@Component
@Generated
public interface SmsVerificationService {

    SmsVerificationCheckResponse dsSmsVerificationCheck(
        SmsVerificationCheckRequest smsVerificationCheckRequest);
    
    SmsVerificationPostResponse dsSmsVerificationCreate(
        SmsVerificationPostRequest smsVerificationPostRequest);
    
}
