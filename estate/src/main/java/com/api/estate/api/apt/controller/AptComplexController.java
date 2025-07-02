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
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="아파트 단지 정보")
@Slf4j
@RestController
@RequestMapping("/apartment")
public class AptComplexController {

    private final AptComplexService aptComplexService;  //서비스 파일에 생성한 클래스를 DI(생성자주입)

    public AptComplexController(AptComplexService aptComplexService) {
        this.aptComplexService = aptComplexService;
    }

    @Operation(summary = "아파트 단지 리스트", description = "아파트 단지 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ComplexRespDto.class))}),
            @ApiResponse(responseCode = "404", description = "조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ComplexRespDto.class))}),
    })
    @GetMapping("/complexes")
    public ResponseEntity<ResponseDto> getComplex(@Parameter(description = "단지 정보") @Valid @ParameterObject ComplexReqDto reqDto) {


        ComplexRespDto complexRespDto = aptComplexService.getComplexList(reqDto);

        ResponseDto responseDto = ResponseDto.builder()
                .requestParam(ResponseDto.requestParam.builder()
                        .apiDescription("지역 정보")
                        .status("OK")
                        .responseTime(ApiUtils.currentTime())
                        .build())
                .document(complexRespDto)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

}
