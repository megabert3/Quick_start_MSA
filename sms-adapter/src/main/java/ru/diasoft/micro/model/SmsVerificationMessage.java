package ru.diasoft.micro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsVerificationMessage {

    @JsonProperty("quid")
    protected String quid;

    @JsonProperty("phoneNumber")
    protected String phoneNumber;

    @JsonProperty("code")
    protected String code;

}
