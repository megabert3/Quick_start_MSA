/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.services;

import lombok.Generated;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.domain.generated.*;

@Service
@Generated
public class SmsVerificationServiceMock implements SmsVerificationService {

    @Override
    public SmsVerificationCheckResponse dsSmsVerificationCheck(
            SmsVerificationCheckRequest smsVerificationCheckRequest) { 
        return new SmsVerificationCheckResponseMock();  
    } 

    @Override
    public SmsVerificationPostResponse dsSmsVerificationCreate(
            SmsVerificationPostRequest smsVerificationPostRequest) { 
        return new SmsVerificationPostResponseMock();  
    } 

}

