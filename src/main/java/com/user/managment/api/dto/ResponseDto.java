package com.user.managment.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "ResponseDTO",
        description = "Schema to hold User Information"
)
public class ResponseDto {

    @Schema(
            name = "StatusCode",
            description = "Status code in the response",
            example = "200"
    )
private String statusCode;

    @Schema(
            name = "StatusMsg",
            description = "Status Massage in the response",
            example = "200"
    )
private String statusMsg;
}
