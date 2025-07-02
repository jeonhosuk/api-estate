package com.api.estate.api.district.dto;

import com.api.estate.api.common.dto.PageInfoDto;
import com.api.estate.api.district.vo.DistrictVo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record DistrictRespDto(
        List<DistrictList> list
) {
    public record DistrictList(
            @Schema(title = "지역이름") String name
    ) {
        public static DistrictRespDto.DistrictList from(DistrictVo vo) {
            return new DistrictRespDto.DistrictList(
                    vo.name()
            );

        }
    }
}



