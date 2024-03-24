package io.github.hsn.cloud.common.security.component;

import io.github.hsn.cloud.common.api.bean.common.JwtTokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@RequiredArgsConstructor
public class CloudJwtAuthenticationToken implements Authentication {

    private final String credentials;

    private final JwtTokenInfo jwtTokenInfo;

    private boolean aAuthenticated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return null;
    }


    @Override
    public Object getPrincipal() {
        return jwtTokenInfo;
    }

    @Override
    public boolean isAuthenticated() {
        return aAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.aAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return jwtTokenInfo.getUsername();
    }
}
