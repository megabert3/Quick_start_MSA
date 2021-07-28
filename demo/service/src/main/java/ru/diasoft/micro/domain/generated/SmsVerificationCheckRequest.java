/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.domain.generated;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SmsVerificationCheckRequest", description = "")
@JsonFilter("DynamicExclude")
@Generated
public class SmsVerificationCheckRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "ProcessGUID", dataType = "String", value = "GUID процесса", required = false, position = 1)
    @JsonProperty("ProcessGUID")
    private String processGUID;

    @ApiModelProperty(name = "Code", dataType = "String", value = "Проверочный код", required = false, position = 2)
    @JsonProperty("Code")
    private String code;

}
