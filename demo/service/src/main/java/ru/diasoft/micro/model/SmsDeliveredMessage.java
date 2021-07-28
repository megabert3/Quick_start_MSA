package ru.diasoft.micro.model;

import lombok.*;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SmsDeliveredMessage {
    @JsonProperty("quid")
    protected String quid;
}
