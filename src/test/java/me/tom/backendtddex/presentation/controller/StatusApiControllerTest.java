package me.tom.backendtddex.presentation.controller;

import me.tom.backendtddex.presentation.model.response.GenericResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StatusApiControllerTest {

    public static final String TOM_API_V_0_1_STATUS_HEALTH = "/tom-api/v0.1/status/health";
    public static final String TOM_API_V_0_1_STATUS_MEMORY_INFO = "/tom-api/v0.1/status/memory-info";
    @Autowired
    private TestRestTemplate testRestTemplate;

    // 이 API에서 뭘 하고싶은 것인가... 이해하는게 필요...
    // 변화가 있는 것들은 존재하는지만 확인



    @Test
    @DisplayName("Health API 호출 - 서버상태 정상일 때 - OK 응답확인")
    void getHealth_whenServerIsValid_receiveOk() {
        //  Given
        //  When
        ResponseEntity<Object> response = testRestTemplate.getForEntity(TOM_API_V_0_1_STATUS_HEALTH, Object.class);
        //  Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    @DisplayName("Health API 호출 - 서버상태 정상일 때 - 응답 메세지 확인")
    public void getHealth_whenServerIsValid_receiveMessage() {
        //  Given
        //  When
        ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(TOM_API_V_0_1_STATUS_HEALTH, GenericResponse.class);
        //  Then
        assertThat(response.getBody().getMessage()).isNotBlank();
    }

    @Test
    @DisplayName("Health API 호출 - 서버상태 정상일 때 - 서버이름, 버전, 시간 확인")
    public void getHealth_whenServerIsValid_serverNameAndVersionAndTimeStampExist() {
        //  Given
        //  When
        ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(TOM_API_V_0_1_STATUS_HEALTH, GenericResponse.class);
        Map<String, String> data = (Map<String, String>) response.getBody().getData();
        //  Then
        assertThat(data.get("name")).isNotBlank();
        assertThat(data.get("version")).isNotBlank();
        assertThat(data.get("timeStamp")).isNotBlank();
    }

    @Test
    @DisplayName("Health API 호출 - 서버상태 정상일 때 - 메모리 정보 응답확인")
    void getMemoryInfo_whenServerIsValid_receiveOk() {
        //  Given
        //  When
        var response = testRestTemplate.getForEntity(TOM_API_V_0_1_STATUS_MEMORY_INFO, GenericResponse.class);
        Map<String, Object> data = (Map<String, Object>) response.getBody().getData();
        //  Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(data.get("serverMaxMemory")).isNotNull();
        assertThat(data.get("serverFreeMemory")).isNotNull();
        assertThat(data.get("serverTotalMemory")).isNotNull();
    }
}