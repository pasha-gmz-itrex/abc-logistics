package com.abc.logistics.dto.models.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidRequestError {

    @ApiModelProperty(value = "Error message", position = 1)
    @JsonProperty("message")
    private String message;

    @ApiModelProperty(value = "List of error details, icl. field name and detailed error message e.g. from field name or missing required field")
    @JsonProperty("details")
    private List<InvalidRequestDetails> details;
}
