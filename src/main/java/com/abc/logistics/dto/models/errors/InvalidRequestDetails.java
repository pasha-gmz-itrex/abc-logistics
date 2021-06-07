package com.abc.logistics.dto.models.errors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidRequestDetails {

    @ApiModelProperty("Field name with wrong value")
    private String field;

    @ApiModelProperty("Error message, e.g. required or unknown field")
    private String message;
}
