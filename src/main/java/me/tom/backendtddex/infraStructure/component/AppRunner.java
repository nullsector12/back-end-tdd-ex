package me.tom.backendtddex.infraStructure.component;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Order(1)
@Slf4j
public class AppRunner implements ApplicationRunner {

    private final EnvComponent envComponent;

    @Override
    public void run(ApplicationArguments args) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(" NAME: {} ", EnvComponent.NAME);
        log.info(" VERSION: {} ", EnvComponent.VERSION);
        log.info(" PROFILES: {} ", envComponent.getActiveProfiles());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


    }
}
