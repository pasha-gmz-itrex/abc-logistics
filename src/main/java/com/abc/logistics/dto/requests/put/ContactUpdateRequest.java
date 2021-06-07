package com.abc.logistics.dto.requests.put;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactUpdateRequest {

    @ApiModelProperty(required = true, value = "Country of contact")
    @JsonProperty("country")
    private String country;
}
