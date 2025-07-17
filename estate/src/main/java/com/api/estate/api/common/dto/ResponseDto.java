package com.api.estate.api.common.dto;
import com.api.estate.api.common.dto.PageInfoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "common response")
public class ResponseDto<T> {

    @Schema(description = "메타 정보")
    private requestParam requestParam;

    @Schema(description = "페이지 정보")
    private PageInfo pageInfo;

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

    @Data
    @Builder
    @Schema(description = "페이지 정보")
    public static class PageInfo {  // 대문자로 변경
        @Schema(description = "현재 페이지")
        private Integer page;

        @Schema(description = "페이지당 데이터 수")
        private Integer pageSize;

        @Schema(description = "전체 데이터 수")
        private Integer totalCount;

        @Schema(description = "전체 페이지 수")
        private Integer totalPage;

        public static PageInfo from(PageInfoDto<?> dto) {
            return PageInfo.builder()  // 이제 정상 작동
                    .page(dto.page())
                    .pageSize(dto.pageSize())
                    .totalCount(dto.totalCount())
                    .totalPage(dto.totalPage())
                    .build();
        }
    }
}