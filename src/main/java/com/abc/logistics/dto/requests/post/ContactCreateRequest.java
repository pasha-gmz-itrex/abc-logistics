package com.abc.logistics.dto.requests.post;

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
public class ContactCreateRequest {

    @ApiModelProperty(required = true, value = "Email of contact")
    @JsonProperty("email")
    private String email;

    @ApiModelProperty(required = true, value = "Country of contact")
    @JsonProperty("country")
    private String country;
}
