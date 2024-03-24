package io.github.hsn.cloud.common.security.component;

import io.github.hsn.cloud.common.api.bean.common.CloudUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CloudUserDetails implements UserDetails {


    @Getter
    @Setter
    private String id;

    private String password;

    private final String userAccount;

    public CloudUserDetails(CloudUser cloudUser) {
        this.userAccount = cloudUser.getUsername();
        this.password = cloudUser.getPassword();
        this.id = cloudUser.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("test");
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
