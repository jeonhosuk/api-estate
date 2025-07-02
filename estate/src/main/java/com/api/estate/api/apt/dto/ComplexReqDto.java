package com.api.estate.api.apt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(title = "지역 입력 값")
public class ComplexReqDto {
   @NotBlank(message = "addr1(주소1)은 필수입니다.")
   @Schema(description = "주소1(서울특별시)")  private String addr1;

   @Schema(description = "주소2(구시군)") private String addr2 = "";

   @Schema(description = "주소3(읍면동)") private String addr3 = "";

   @Schema(description = "아파트코드") private String complexCode = "";

   @Schema(description = "현재페이지") private Integer page = 1;

   @Schema(description = "데이터노출개수") private Integer pageSize = 500;
}