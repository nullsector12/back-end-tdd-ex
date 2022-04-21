package me.tom.backendtddex.infraStructure.component;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnvComponent {

    public static String NAME = "back-end-tdd-ex";
    public static String VERSION = "0.1";

    private final Environment environment;

    public String getActiveProfiles() {
        return String.join(",",environment.getActiveProfiles());
    }


}
