package ru.onthelastjourney.backend.util.encoder;

import org.mindrot.jbcrypt.BCrypt;


public class BCryptEncoder implements Encoder {

    private final String salt;

    public BCryptEncoder(String salt) {
        this.salt = salt;
    }

    @Override
    public String encode(String original) {
        return BCrypt.hashpw(original, salt);
    }
}
