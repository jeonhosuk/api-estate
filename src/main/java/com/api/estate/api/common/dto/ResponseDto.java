package com.api.estate.api.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "common response")
public class ResponseDto<T> {

    @Schema(description = "api response code")
    private int code;

    @Schema(description = "api name")
    private String api_description;

    @Schema(description = "api msg", example = "OK/error")
    private String status; //에러 또는 성공 메세지 제공

    @Schema(description = "body data")
    private T body;
}
