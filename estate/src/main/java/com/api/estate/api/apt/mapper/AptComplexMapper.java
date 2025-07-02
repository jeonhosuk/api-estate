package com.api.estate.api.apt.mapper;


import com.api.estate.api.apt.vo.AptComplexVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AptComplexMapper {

    List<AptComplexVo> getComplexList(
            @Param("addr1") String addr1, @Param("addr2") String addr2, @Param("addr3") String addr3,
            @Param("complexCode") String complexCode, @Param("page") Integer page, @Param("pageSize") Integer pageSize
    );

}
