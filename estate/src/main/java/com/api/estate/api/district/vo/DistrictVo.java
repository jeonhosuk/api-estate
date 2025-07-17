package com.api.estate.api.district.vo;

import io.swagger.v3.oas.annotations.media.Schema;

public record DistrictVo(
        @Schema(description = "주소") String name
)
{}