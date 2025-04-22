package com.api.estate.api.apt.controller;

import com.api.estate.api.apt.dto.ComplexReqDto;
import com.api.estate.api.apt.dto.ComplexRespDto;
import com.api.estate.api.apt.service.AptComplexService;
import com.api.estate.api.common.dto.ResponseDto;
import com.api.estate.api.common.util.ApiUtils;
import com.api.estate.api.district.dto.DistrictRespDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController            // restapi 사용시 추가되는 어노테이션
@RequestMapping("/v1")     // /url이 호출 됐을 때 해당 메소드를 실행하도록 매핑
public class AptComplexController {

    private final AptComplexService aptComplexService;  //서비스 파일에 생성한 클래스를 DI(생성자주입)

    public AptComplexController(AptComplexService aptComplexService) {
        this.aptComplexService = aptComplexService;
    }

    @Operation(summary = "지역정보 리스트", description = "지역정보 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DistrictRespDto.class))}),
            @ApiResponse(responseCode = "404", description = "조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DistrictRespDto.class))}),
    })
    @GetMapping("/complex")
    public ResponseEntity<ResponseDto> complex(@Parameter(description = "단지 정보") @Valid @ParameterObject ComplexReqDto reqDto) {

        log.info("addr1: {}", reqDto.addr1());
        log.info("addr2: {}", reqDto.addr2());

        ComplexRespDto complexRespDto = aptComplexService.complexInfo(reqDto);

        ResponseDto responseDto = ResponseDto.builder()
                .meta(ResponseDto.Meta.builder()
                        .api_description("지역 정보")
                        .status("OK")
                        .response_time(ApiUtils.currentTime())
                        .build())
                .document(complexRespDto)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

}
