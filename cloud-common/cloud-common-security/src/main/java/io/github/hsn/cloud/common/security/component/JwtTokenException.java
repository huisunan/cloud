package io.github.hsn.cloud.common.security.component;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenException extends AuthenticationException {

    public JwtTokenException(String msg) {
        super(msg);
    }

    public JwtTokenException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
