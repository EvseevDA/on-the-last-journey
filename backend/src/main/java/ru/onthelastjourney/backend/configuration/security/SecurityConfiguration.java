package ru.onthelastjourney.backend.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.onthelastjourney.backend.util.encoder.BCryptEncoder;
import ru.onthelastjourney.backend.util.encoder.Encoder;

@Configuration
public class SecurityConfiguration {

    @Bean
    public Encoder passwordEncoder() {
        return new BCryptEncoder();
    }

}
