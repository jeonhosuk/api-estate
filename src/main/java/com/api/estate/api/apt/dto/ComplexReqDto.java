package com.api.estate.api.apt.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "지역 입력 값")
public record ComplexReqDto (
   @Schema(description = "주소1(공백 or 서울특별시)") String addr1,
   @Schema(description = "주소2(구시군)") String addr2,
   @Schema(description = "주소3(읍면동)") String addr3,
   @Schema(description = "아파트코드") String complex_code
)
{}