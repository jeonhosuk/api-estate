package com.api.estate.api.apt.controller;

import com.api.estate.api.apt.service.AptInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController            // restapi 사용시 추가되는 어노테이션
@RequestMapping("/v1")     // /url이 호출 됐을 때 해당 메소드를 실행하도록 매핑
public class AptInfoController {
//
//    private final AptInfoService aptInfoService;  //서비스 파일에 생성한 클래스를 DI(생성자주입)
//
//    public AptInfoController(AptInfoService aptInfoService) {
//        this.aptInfoService = aptInfoService;
//    }

}
