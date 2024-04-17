package io.github.hsn.cloud.common.security.grant;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@RequiredArgsConstructor
public class RoleGrantedAuthority implements GrantedAuthority {

    private final String roleCode;

    @Override
    public String getAuthority() {
        return roleCode;
    }
}
