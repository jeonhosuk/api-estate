package com.api.estate.api.interceptor;

import com.api.estate.api.common.mapper.ApiRoleMapper;
import com.api.estate.api.common.util.ApiUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class ApiInterceptor implements HandlerInterceptor {

    private final ApiRoleMapper apiRoleMapper;

    public ApiInterceptor(ApiRoleMapper apiRoleMapper) {
        this.apiRoleMapper = apiRoleMapper;
    }
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // API 키 검증
        String apiKey = request.getHeader("X-API-KEY");
        String requestURI = request.getRequestURI();

        System.out.println("API URI: " + requestURI + ", API key: " + apiKey);

        /*if (!StringUtils.hasText(apiKey) || !isValidApiKey(apiKey)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "유효하지 않은 API 키입니다.");
            return false; // 요청 진행 중단
        }

        if (!isValidApiListChk(apiKey, requestURI)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "권한이 부여되지 않았습니다.");
            return false; // 요청 진행 중단
        }*/

        return true; // 요청 계속 진행
    }

    private boolean isValidApiKey(String apiKey) {

        String useYn = apiRoleMapper.getApiUseYn(apiKey);

        return "Y".equals(useYn);
    }

    private boolean isValidApiListChk(String apiKey, String requestURI) {
        String apiName = ApiUtils.extractApiName(requestURI);

        String useYn = apiRoleMapper.getApiListUseYn(apiKey, apiName);
        System.out.println("API nm : " + apiName);

        return "Y".equals(useYn);
    }
}
