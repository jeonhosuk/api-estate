package com.api.estate.api.apt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public record AptComplexVo(
        @Schema(description = "총데이터수") Integer totalCount,
        @Schema(description = "아파트코드") String complexCode,
        @Schema(description = "아파트명") String complexName,
        @Schema(description = "도시") String addr1,
        @Schema(description = "구시군") String addr2,
        @Schema(description = "읍면동") String addr3,
        @Schema(description = "공급면적(46㎡)") String areaView,
        @Schema(description = "공급면적평형(13)") String areaViewPy,
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


