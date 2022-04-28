package me.tom.backendtddex.presentation.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ServerMemoryResponse {

    private Long serverMaxMemory;

    private Long serverFreeMemory;

    private Long serverTotalMemory;

    public ServerMemoryResponse () {
//        this.serverMaxMemory = 0L;
//        this.serverFreeMemory = 0L;
//        this.serverTotalMemory = 0L;

        this.serverMaxMemory = Runtime.getRuntime().maxMemory();
        this.serverFreeMemory = Runtime.getRuntime().freeMemory();
        this.serverTotalMemory = Runtime.getRuntime().totalMemory();
    }
}
