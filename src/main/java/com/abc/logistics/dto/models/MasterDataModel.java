package com.abc.logistics.dto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasterDataModel {

    @ApiModelProperty(value = "Master data unique identifier", position = 1)
    @JsonProperty("id")
    private String id;

    @ApiModelProperty(value = "Master data field 1", position = 2)
    @JsonProperty("field1")
    private String field1;

    @ApiModelProperty(value = "Master data field 2", position = 3)
    @JsonProperty("field2")
    private String field2;
}
