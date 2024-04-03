package io.github.hsn.cloud.common.security.component;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class PermissionGrantedAuthority implements GrantedAuthority {
    private final String permission;

    @Override
    public String getAuthority() {
        return permission;
    }
}
