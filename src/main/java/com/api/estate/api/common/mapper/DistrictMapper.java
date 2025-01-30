package com.api.estate.api.common.mapper;

import com.api.estate.api.common.vo.DistrictVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistrictMapper {

    public List<DistrictVo> getDistrictList();
}
