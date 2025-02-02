package com.api.estate.api.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApiInterceptor implements HandlerInterceptor {
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // API 키 검증
        String apiKey = request.getHeader("X-API-KEY");

//        if (!StringUtils.hasText(apiKey) || !isValidApiKey(apiKey)) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "유효하지 않은 API 키입니다.");
//            return false; // 요청 진행 중단
//        }

//        if (!StringUtils.hasText(apiKey)){
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "유효하지 않은 API 키입니다.");
//            return false;
//        }

        System.out.println("API 호출 전 - URI: " + request.getRequestURI() + ", API 키: " + apiKey);

        return true; // 요청 계속 진행
    }

//    private boolean isValidApiKey(String apiKey) {
//
//    }
}
