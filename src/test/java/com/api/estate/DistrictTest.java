package com.api.estate;

import com.api.estate.api.district.dto.DistrictReqDto;
import com.api.estate.api.district.dto.DistrictRespDto;
import com.api.estate.api.district.mapper.DistrictMapper;
import com.api.estate.api.district.service.DistrictService;
import com.api.estate.api.district.vo.DistrictVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class DistrictTest {
    @Mock
    private DistrictMapper districtMapper;  // Mock으로 주입할 의존성

    @InjectMocks
    private DistrictService districtService; // 테스트 대상 클래스

    private DistrictVo nameVo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // 테스트 데이터 준비
        nameVo = new DistrictVo();
        nameVo.setName("서울특별시");
    }

    @Test
    @DisplayName("주소가 빈 문자열인 경우 테스트")
    void districtInfo_EmptyStringAddress() {
        // Given
        DistrictReqDto reqDto = new DistrictReqDto("", "");
        List<DistrictVo> mockCities = Arrays.asList(nameVo);
        System.out.println("Mock cities: " + mockCities);

        when(districtMapper.getDistrictList(eq("도시"), eq(""), eq("")))
                .thenReturn(mockCities);

        // When
        DistrictRespDto result = districtService.districtInfo(reqDto);
        System.out.println("Result: " + result);

        // Then
        assertNotNull(result);
        assertEquals(1, result.getList().size());
        System.out.println("Test completed successfully");
    }
}
