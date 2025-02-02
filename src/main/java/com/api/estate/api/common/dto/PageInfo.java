package com.api.estate.api.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageInfo {

    @Schema(title = "현재 페이지")
    private int page;

    @Schema(title = "페이지 크기")
    private int pageSize;

    @Schema(title = "전체페이지")
    private int totalPage;

    @Schema(title = "전체 개수")
    private int totalCount;
}
