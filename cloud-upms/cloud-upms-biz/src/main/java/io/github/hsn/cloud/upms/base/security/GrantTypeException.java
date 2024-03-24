package io.github.hsn.cloud.upms.base.security;

import org.springframework.security.core.AuthenticationException;

public class GrantTypeException extends AuthenticationException {

    public GrantTypeException(String msg) {
        super(msg);
    }

    public GrantTypeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
