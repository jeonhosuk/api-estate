package com.api.estate.api.apt.service;

import com.api.estate.api.apt.dto.ComplexReqDto;
import com.api.estate.api.apt.dto.ComplexRespDto;
import com.api.estate.api.apt.mapper.AptComplexMapper;
import com.api.estate.api.district.dto.DistrictReqDto;
import com.api.estate.api.district.dto.DistrictRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AptComplexService {

    private final AptComplexMapper aptComplexMapper; //Mapper 파일에 생성한 인터페이스를 DI(생성자주입)

    public AptComplexService(AptComplexMapper aptComplexMapper) {
        this.aptComplexMapper = aptComplexMapper;
    }

    public ComplexRespDto complexInfo(ComplexReqDto reqDto) {


         return ComplexRespDto.builder()
//                .list()
                .build();
    }

}
