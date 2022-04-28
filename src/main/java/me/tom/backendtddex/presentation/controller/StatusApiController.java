package me.tom.backendtddex.presentation.controller;

import me.tom.backendtddex.infraStructure.component.EnvComponent;
import me.tom.backendtddex.presentation.model.response.GenericResponse;
import me.tom.backendtddex.presentation.model.response.ServerMemoryResponse;
import me.tom.backendtddex.presentation.model.response.ServerStatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/tom-api/v0.1/status")
public class StatusApiController {

    @GetMapping("/health")
    public GenericResponse<Object> health() {
        return new GenericResponse<>(
                "서버 상태 On",
                new ServerStatusResponse()
        );
    }

    @GetMapping("/memory-info")
    public GenericResponse<ServerMemoryResponse> memoryInfo() {
        return new GenericResponse<>(
                "서버 상태 On",
                new ServerMemoryResponse()
        );

    }
}
