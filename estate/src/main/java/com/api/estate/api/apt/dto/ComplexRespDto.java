package com.api.estate.api.apt.dto;

import com.api.estate.api.apt.vo.AptComplexVo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ComplexRespDto(
        @Schema(description = "아파트 단지 리스트") List<ComplexList> list
) {
    public record ComplexList(
            @Schema(title = "아파트코드") String complexCode,
            @Schema(title = "아파트이름") String complexName,
            @Schema(title = "도시") String addr1

    ) {
        public static ComplexList from(AptComplexVo vo) {
            return new ComplexList(
                    vo.complexCode(),
                    vo.complexName(),
                    vo.addr1()
            );

        }
    }
}
