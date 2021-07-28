/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.micro.domain.generated.SmsVerificationCheckRequest;
import ru.diasoft.micro.domain.generated.SmsVerificationCheckResponse;
import ru.diasoft.micro.domain.generated.SmsVerificationPostRequest;
import ru.diasoft.micro.domain.generated.SmsVerificationPostResponse;
import ru.diasoft.micro.lib.config.aop.Loggable;
import ru.diasoft.micro.lib.utils.response.RESTStatus;
import ru.diasoft.micro.services.SmsVerificationService;

@RestController("ru.diasoft.micro.controller.SmsVerificationController")
@Api(tags = {"SmsVerification"})
@Generated
@Loggable
public class SmsVerificationController {

    private final SmsVerificationService smsVerificationService;
    
    @Autowired    
    public SmsVerificationController(SmsVerificationService smsVerificationService) {
        this.smsVerificationService = smsVerificationService;
    }

    @GetMapping("/v1/sms-verification")
    @ApiOperation(value = "Метод проверяет, что введенный код соответствует отправленному.", response = SmsVerificationCheckResponse.class, tags = {"SmsVerification"})
    public ResponseEntity<SmsVerificationCheckResponse> dsSmsVerificationCheck(
                @RequestParam(value = "processguid", defaultValue = "0") @ApiParam(value = "processGUID", required = false)
                String processGUID,

                @RequestParam(value = "code", defaultValue = "0") @ApiParam(value = "Секретный код", required = false)
                String code) {

        SmsVerificationCheckResponse result = smsVerificationService.dsSmsVerificationCheck(
                SmsVerificationCheckRequest.builder()
                        .processGUID(processGUID)
                        .code(code)
                        .build());

        if (result instanceof RESTStatus) {
            return ResponseEntity.status(((RESTStatus)result).getHttpStatus()).body(result);    
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result); 
        }
    }

    @PostMapping("/v1/sms-verification")
    @ApiOperation(value = "Отправка проверочного кода на телефон клиента.", response = SmsVerificationPostResponse.class, tags = {"SmsVerification"})
    public ResponseEntity<SmsVerificationPostResponse> dsSmsVerificationCreate(
                @RequestBody(required = true)
                @ApiParam(name = "SmsVerificationPostRequest", value = "", required = true)
                SmsVerificationPostRequest smsVerificationPostRequest) {

        SmsVerificationPostResponse result = smsVerificationService.dsSmsVerificationCreate(
                smsVerificationPostRequest);

        if (result instanceof RESTStatus) {
            return ResponseEntity.status(((RESTStatus)result).getHttpStatus()).body(result);    
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result); 
        }
    }

}
