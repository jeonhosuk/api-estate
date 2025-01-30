package com.api.estate.api.apt.service;

import com.api.estate.api.apt.mapper.AptInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AptInfoService {

    private final AptInfoMapper aptInfoMapper; //Mapper 파일에 생성한 인터페이스를 DI(생성자주입)

    public AptInfoService(AptInfoMapper aptinfoMapper) {
        this.aptInfoMapper = aptinfoMapper;
    }


}
