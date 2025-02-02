package com.api.estate.api.district.service;


import com.api.estate.api.district.dto.DistrictReqDto;
import com.api.estate.api.district.dto.DistrictRespDto;
import com.api.estate.api.district.mapper.DistrictMapper;
import com.api.estate.api.district.vo.DistrictVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class DistrictService {
    private final DistrictMapper districtMapper; //Mapper 파일에 생성한 인터페이스를 DI(생성자주입)

    public DistrictService(DistrictMapper districtMapper) {
        this.districtMapper = districtMapper;
    }

    public DistrictRespDto districtInfo(DistrictReqDto reqDto) {
        String addr1 = reqDto.addr1();
        String addr2 = reqDto.addr2();
        String level = "";

        if((addr1 == null || addr1.trim().isEmpty()) && (addr2 == null || addr2.trim().isEmpty())){
            level = "도시";
        }else if ((addr1 != null && !addr1.trim().isEmpty()) && (addr2 == null || addr2.trim().isEmpty())){
            level = "구시군";
        }else if (!Objects.equals(addr1, null) && !Objects.equals(addr2, null)) {
            level = "읍면동";
        }else{
            level = "도시";
        }
        log.info("level : {}", level);

        List<DistrictVo> districtList = districtMapper.getDistrictList(level, reqDto.addr1(),reqDto.addr2());

        List<DistrictRespDto.DistrictList> names = new ArrayList<>();
        if(districtList != null && !districtList.isEmpty()) {
            for (DistrictVo districtVo : districtList) {
                DistrictRespDto.DistrictList list = DistrictRespDto.DistrictList.builder()
                        .name(districtVo.getName())
                        .build();
                names.add(list);
            }
        }


        return DistrictRespDto.builder()
                .list(names)
                .build();
    }

}