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
            @Schema(title = "도시") String addr1,
            @Schema(title = "구시군") String addr2,
            @Schema(title = "읍면동") String addr3,
            @Schema(description = "면적 정보 리스트") List<AreaInfo> areaList
    ){}

    @Schema(description = "면적 정보")
    public record AreaInfo(
            @Schema(description = "공급면적(46A)") String areaView,
            @Schema(description = "공급면적의평형(13)") String areaViewPy,
            @Schema(description = "평형값(00012)") String areaSize,
            @Schema(description = "평형타입(A)") String areaSizeType,
            @Schema(description = "총세대수") String householdsCntTotal,
            @Schema(description = "세대수") String householdsCnt,
            @Schema(description = "현관구조") String entrance,
            @Schema(description = "방수") String roomCnt,
            @Schema(description = "욕실수") String bathroomCnt,
            @Schema(description = "동") String dong,
            @Schema(description = "호수") String ho,
            @Schema(description = "난방연료") String heating,
            @Schema(description = "난방방식") String heatingType,
            @Schema(description = "입주연도") String moveInDate
    ) {}
}
