package com.api.estate.api.apt.service;

import com.api.estate.api.apt.dto.ComplexReqDto;
import com.api.estate.api.apt.dto.ComplexRespDto;
import com.api.estate.api.apt.mapper.AptComplexMapper;
import com.api.estate.api.apt.vo.AptComplexVo;
import com.api.estate.api.common.dto.PageInfoDto;
import com.api.estate.api.common.util.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

@Slf4j
@Service
public class AptComplexService {

    private final AptComplexMapper aptComplexMapper; //Mapper 파일에 생성한 인터페이스를 DI(생성자주입)

    public AptComplexService(AptComplexMapper aptComplexMapper) {
        this.aptComplexMapper = aptComplexMapper;
    }

    public PageInfoDto<ComplexRespDto.ComplexList> getComplexList(ComplexReqDto reqDto) {

        List<AptComplexVo> getComplexList = aptComplexMapper.getComplexList(reqDto.getAddr1(),reqDto.getAddr2(),reqDto.getAddr3(),reqDto.getComplexCode(),reqDto.getPage(),reqDto.getPageSize());

        Map<String, List<AptComplexVo>> groupedByComplex = getComplexList.stream()
                .collect(Collectors.groupingBy(
                        AptComplexVo::complexCode,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        List<ComplexRespDto.ComplexList> complexList = groupedByComplex.values().stream()
                .map(group -> {
                    AptComplexVo vo = group.get(0);
                    List<ComplexRespDto.AreaInfo> areaList = group.stream()
                            .map(v -> new ComplexRespDto.AreaInfo(
                                    v.areaView(),
                                    v.areaViewPy(),
                                    v.areaSize(),
                                    v.areaSizeType(),
                                    v.householdsCntTotal(),
                                    v.householdsCnt(),
                                    v.entrance(),
                                    v.roomCnt(),
                                    v.bathroomCnt(),
                                    v.dong(),
                                    v.ho(),
                                    v.heating(),
                                    v.heatingType(),
                                    v.moveInDate()
                            ))
                            .toList();

                    return new ComplexRespDto.ComplexList(
                            vo.complexCode(),
                            vo.complexName(),
                            vo.addr1(),
                            vo.addr2(),
                            vo.addr3(),
                            areaList
                    );
                })
                .toList();

        int totalCount = getComplexList.isEmpty() ? 0 : getComplexList.get(0).totalCount();

        return ApiUtils.buildPageInfo(
                reqDto.getPage(),
                reqDto.getPageSize(),
                totalCount,
                complexList
        );

    }

}
