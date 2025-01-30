package com.api.estate.api.common.service;


import com.api.estate.api.common.dto.DistrictDto;
import com.api.estate.api.common.mapper.DistrictMapper;
import com.api.estate.api.common.vo.DistrictVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class DistrictService {
    private final DistrictMapper districtMapper; //Mapper 파일에 생성한 인터페이스를 DI(생성자주입)

    public DistrictService(DistrictMapper districtMapper) {
        this.districtMapper = districtMapper;
    }

    public DistrictDto districtInfo(){

        List<DistrictVo> districtList = districtMapper.getDistrictList();

        return DistrictDto.builder()
                .build();
    }

}
