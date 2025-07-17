package com.api.estate.api.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record PageInfoDto<T>(
        @Schema(title = "현재 페이지") int page,
        @Schema(title = "한 페이지에 보여줄 데이터 개수") int pageSize,
        @Schema(title = "전체 페이지") int totalPage,
        @Schema(title = "전체 데이터 개수") int totalCount,
        @Schema(title = "데이터 목록") List<T> list
)
{}
