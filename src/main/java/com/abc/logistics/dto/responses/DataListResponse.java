package com.abc.logistics.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataListResponse<T> {

    @ApiParam(
        value = "Total records in the data source which fulfill filter criteria",
        defaultValue = "0",
        example = "0"
    )
    @ApiModelProperty(position = 2)
    private Long total = 0L;

    @ApiParam(value = "List of data records")
    @ApiModelProperty(position = 3)
    private List<T> results = new ArrayList<>();

    @ApiParam(
        value = "Count of selected records on the current page",
        defaultValue = "0",
        example = "0"
    )
    @ApiModelProperty(position = 1)
    @JsonProperty("count")
    public Long getCount() {
        return (results != null) ? (long) results.size() : 0L;
    }
}
