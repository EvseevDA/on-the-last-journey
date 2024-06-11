package ru.onthelastjourney.backend.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.onthelastjourney.backend.util.encoder.BCryptEncoder;
import ru.onthelastjourney.backend.util.encoder.Encoder;

@Configuration
public class SecurityConfiguration {

    @Value("${bcrypt.salt}")
    private String salt;

    @Bean
    public Encoder passwordEncoder() {
        return new BCryptEncoder(salt);
    }

}
