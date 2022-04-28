package me.tom.backendtddex.presentation.model.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class ServerStatusResponseTest {

    @Test
    @DisplayName("상태응답 생성 - timestamp 가 주어졌을 때, timeStamp가 일치하는지 확인")
    public void createStatusResponse_whenUseGivenTimeStamp_check() {
        // now() 같은 컨트롤할 수 없는 데이터들은 모두 외부에서 받아오도록 빼내야 한다.
        // Given
        var defaultDays = LocalDateTime.of(2022, 4, 20, 18,0,0);
        // When
        ServerStatusResponse serverStatusResponse = new ServerStatusResponse(defaultDays);
        // Then
        assertThat(serverStatusResponse.getTimeStamp()).isEqualTo(defaultDays);
    }

    @Test
    @DisplayName("상태응답 생성 - timestamp 가 주어졌을 때, fiveDaysLater가 일치하는지 확인")
    public void createStatusResponse_whenUseGivenTimeStamp_checkFiveDaysLaterFunction() {
        // now() 같은 컨트롤할 수 없는 데이터들은 모두 외부에서 받아오도록 빼내야 한다.
        // Given
        var defaultDays = LocalDateTime.of(2022, 4, 20, 18,0,0);
        var defaultFiveDaysLater = LocalDateTime.of(2022, 4, 20, 18, 0, 0).plusDays(5);
        // When
        ServerStatusResponse serverStatusResponse = new ServerStatusResponse(defaultDays);
        // Then
        assertThat(serverStatusResponse.fiveDaysLater()).isEqualTo(defaultFiveDaysLater);
    }

}