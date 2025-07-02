package com.api.estate.api.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record PageInfoDto(
        @Schema(title = "현재 페이지") int page,
        @Schema(title = "페이지 크기") int pageSize,
        @Schema(title = "전체 페이지") int totalPage,
        @Schema(title = "전체 개수") int totalCount
)
{}
