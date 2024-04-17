package io.github.hsn.cloud.common.security.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenException extends AuthenticationException {

    public JwtTokenException(String msg) {
        super(msg);
    }

    public JwtTokenException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
