package com.abc.logistics.dto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactModel {

    @ApiModelProperty(value = "Contact unique identifier", position = 1)
    @JsonProperty("id")
    private String id;

    @ApiModelProperty(value = "Email of contact", position = 2)
    @JsonProperty("email")
    private String email;

    @ApiModelProperty(value = "Country of contact", position = 3)
    @JsonProperty("country")
    private String country;
}
