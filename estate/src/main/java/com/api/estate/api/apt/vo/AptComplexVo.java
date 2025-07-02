package com.api.estate.api.apt.vo;

import io.swagger.v3.oas.annotations.media.Schema;

public record AptComplexVo(
        @Schema(description = "아파트명") String complexName,
        @Schema(description = "아파트코드") String complexCode,
        @Schema(description = "도시") String addr1,
        @Schema(description = "구시군") String addr2,
        @Schema(description = "읍면동") String addr3

) {}
