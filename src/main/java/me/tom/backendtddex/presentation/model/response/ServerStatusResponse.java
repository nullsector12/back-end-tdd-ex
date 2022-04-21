package me.tom.backendtddex.presentation.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.tom.backendtddex.infraStructure.component.EnvComponent;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServerStatusResponse {

    private String name;
    private String version;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss z", timezone = "Asia/Seoul")
    private LocalDateTime timeStamp;

    public ServerStatusResponse() {
        this.name = EnvComponent.NAME;
        this.version = EnvComponent.VERSION;
        this.timeStamp = LocalDateTime.now();
    }
}
