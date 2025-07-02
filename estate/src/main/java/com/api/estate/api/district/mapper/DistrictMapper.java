package com.api.estate.api.district.mapper;

import com.api.estate.api.district.vo.DistrictVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DistrictMapper {

    List<DistrictVo> getDistrictList(@Param("level") String level, @Param("addr1") String addr1, @Param("addr2") String addr2);
}
