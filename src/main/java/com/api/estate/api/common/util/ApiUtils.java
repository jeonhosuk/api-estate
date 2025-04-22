package com.api.estate.api.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiUtils {
    private ApiUtils() {
        // 유틸리티 클래스는 인스턴스화 방지
    }

    /**
     * URI에서 API 이름을 추출하는 공통 메서드
     *
     * @param uri 요청 URI
     * @return 추출된 API 이름 (예: /v1/district -> district)
     */
    public static String extractApiName(String uri) {
        if (uri == null || uri.isEmpty()) {
            return "";
        }
        String[] parts = uri.split("/");
        return parts.length > 0 ? parts[parts.length - 1] : "";
    }
    public static String currentTime(){
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        return currentTime;
    }
    
}
