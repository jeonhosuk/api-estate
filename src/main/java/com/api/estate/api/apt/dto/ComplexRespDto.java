package com.api.estate.api.apt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplexRespDto {

    private List<DistrictList> list;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DistrictList {
        @Schema(title = "지역이름")
        private String name;
    }

}
