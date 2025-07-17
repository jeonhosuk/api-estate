package com.api.estate.api.district.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "지역 입력 값")
public class DistrictReqDto {
    @Schema(description = "주소1(공백 or 서울특별시)")
    private String addr1;

    @Schema(description = "주소2(구시군)")
    private String addr2;
}

