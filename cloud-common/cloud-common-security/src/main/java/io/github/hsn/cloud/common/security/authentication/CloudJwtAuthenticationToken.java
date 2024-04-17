package io.github.hsn.cloud.common.security.authentication;

import io.github.hsn.cloud.common.security.detail.CloudUserBaseDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@RequiredArgsConstructor
public class CloudJwtAuthenticationToken implements Authentication {

    private final String credentials;

    private final CloudUserBaseDetails cloudUserDetails;

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
        return cloudUserDetails;
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
        return cloudUserDetails.getUsername();
    }
}
