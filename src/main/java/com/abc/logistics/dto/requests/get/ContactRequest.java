package com.abc.logistics.dto.requests.get;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@ApiModel(description = "The list of filters for searching through the contacts")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest extends PageableRequest {

    @ApiModelProperty(value = "Country of contact", required = true)
    private String country;
}
