package ru.onthelastjourney.backend.util.encoder;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;


public class BCryptEncoder implements Encoder {

    @Value("${bcrypt.salt}")
    private String salt;

    @Override
    public String encode(String original) {
        return BCrypt.hashpw(original, salt);
    }
}
