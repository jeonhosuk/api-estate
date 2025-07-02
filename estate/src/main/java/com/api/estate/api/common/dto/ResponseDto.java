package com.api.estate.api.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "common response")
public class ResponseDto<T> {

    @Schema(description = "메타 정보")
    private requestParam requestParam;

    @Schema(description = "body data")
    private T document;

    @Data
    @Builder
    public static class requestParam {
        @Schema(description = "API 설명")
        private String apiDescription;

        @Schema(description = "API 상태", example = "OK/error")
        private String status;

        @Schema(description = "응답 시간", example = "20250302215141")
        private String responseTime;
    }
}
