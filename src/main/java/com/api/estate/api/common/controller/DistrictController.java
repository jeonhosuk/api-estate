package com.api.estate.api.common.controller;

import com.api.estate.api.common.dto.DistrictRespDto;
import com.api.estate.api.common.service.DistrictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController            // restapi 사용시 추가되는 어노테이션
@RequestMapping("/v1")     // /url이 호출 됐을 때 해당 메소드를 실행하도록 매핑
@Tag(name="공통 API")
public class DistrictController {

    private final DistrictService districtService;  //서비스 파일에 생성한 클래스를 DI(생성자주입)

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @Operation(summary = "지역정보 리스트", description = "지역정보 조회 API")
    @GetMapping("/district")
    public DistrictRespDto district(){
        return districtService.districtInfo();
    }
}
