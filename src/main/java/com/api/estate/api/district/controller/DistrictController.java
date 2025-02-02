package com.api.estate.api.district.controller;

import com.api.estate.api.common.dto.ResponseDto;
import com.api.estate.api.district.dto.DistrictReqDto;
import com.api.estate.api.district.dto.DistrictRespDto;
import com.api.estate.api.district.service.DistrictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//api 실행전 interceptor패키지의 의 api 체크 기능 넣어놓음 확인(설정은 /api/config/webconfig)
@Tag(name="공통 API")
@Slf4j
@RestController           
@RequestMapping("/v1")   
public class DistrictController {

    private final DistrictService districtService;  //서비스 파일에 생성한 클래스를 DI(생성자주입)
    private final GenericResponseService responseBuilder;

    public DistrictController(DistrictService districtService, GenericResponseService responseBuilder) {
        this.districtService = districtService;
        this.responseBuilder = responseBuilder;
    }

    @Operation(summary = "지역정보 리스트", description = "지역정보 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DistrictRespDto.class))}),
            @ApiResponse(responseCode = "404", description = "조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DistrictRespDto.class))}),
    })
    @GetMapping("/district")
    public ResponseEntity<ResponseDto> district(@Parameter(description = "지역 검색") @Valid @ParameterObject DistrictReqDto reqDto) {

        log.info("addr1: {}", reqDto.addr1());
        log.info("addr2: {}", reqDto.addr2());

        DistrictRespDto districtRespDto = districtService.districtInfo(reqDto);

        ResponseDto responseDto = ResponseDto.builder()
                .code(HttpStatus.OK.value())
                .api_description("지역 정보")
                .status("OK")
                .body(districtRespDto)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
