package com.abc.logistics.dto.requests.get;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableRequest {

    @ApiModelProperty(
        position = 100,
        value = "Skip N results. 0 if omitted",
        example = "0"
    )
    private Integer skip = 0;

    @ApiModelProperty(
        position = 101,
        value = "Returns no more than N results. 100 records if omitted",
        example = "100"
    )
    private Integer take = 100;
}
