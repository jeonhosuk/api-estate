package com.api.estate.api.apt.service;

import com.api.estate.api.apt.dto.ComplexReqDto;
import com.api.estate.api.apt.dto.ComplexRespDto;
import com.api.estate.api.apt.mapper.AptComplexMapper;
import com.api.estate.api.apt.vo.AptComplexVo;
import com.api.estate.api.district.dto.DistrictReqDto;
import com.api.estate.api.district.dto.DistrictRespDto;
import com.api.estate.api.district.vo.DistrictVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AptComplexService {

    private final AptComplexMapper aptComplexMapper; //Mapper 파일에 생성한 인터페이스를 DI(생성자주입)

    public AptComplexService(AptComplexMapper aptComplexMapper) {
        this.aptComplexMapper = aptComplexMapper;
    }

    public ComplexRespDto getComplexList(ComplexReqDto reqDto) {

        List<AptComplexVo> getComplexList = aptComplexMapper.getComplexList(reqDto.getAddr1(),reqDto.getAddr2(),reqDto.getAddr3(),reqDto.getComplexCode(),reqDto.getPage(),reqDto.getPageSize());

        List<ComplexRespDto.ComplexList> complexList = getComplexList.stream()
                .map(ComplexRespDto.ComplexList::from)
                .toList();

        return new ComplexRespDto(complexList);

    }

}
