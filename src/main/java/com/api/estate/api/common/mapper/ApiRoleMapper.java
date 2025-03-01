package com.api.estate.api.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiRoleMapper {
    public String getApiUseYn(@Param("apiKey") String apiKey);

    public String getApiListUseYn(@Param("apiKey") String apiKey, @Param("apiName") String apiName);
}
