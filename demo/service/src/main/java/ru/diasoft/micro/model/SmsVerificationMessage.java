package ru.diasoft.micro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SmsVerificationMessage {
    @JsonProperty("quid")
    protected String quid;
    @JsonProperty("phoneNumber")
    protected String phoneNumber;
    @JsonProperty("code")
    protected String code;
}
