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
public class MasterDataCreateRequest {

    @ApiModelProperty(required = true, value = "Master data field 1")
    @JsonProperty("field1")
    private String field1;

    @ApiModelProperty(required = true, value = "Master data field 2")
    @JsonProperty("field2")
    private String field2;
}
