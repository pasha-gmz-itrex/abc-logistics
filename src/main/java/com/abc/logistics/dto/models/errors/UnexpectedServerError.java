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
public class UnexpectedServerError {

    @ApiModelProperty(value = "Message of an unexpected error")
    private String message;
}
