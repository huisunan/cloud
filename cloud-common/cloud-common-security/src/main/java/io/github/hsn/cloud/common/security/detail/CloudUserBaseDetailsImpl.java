package io.github.hsn.cloud.common.security.detail;

import cn.hutool.core.collection.CollUtil;
import io.github.hsn.cloud.common.api.bean.common.CloudUserBase;
import io.github.hsn.cloud.common.api.bean.common.CloudUserExtend;
import io.github.hsn.cloud.common.security.grant.RoleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CloudUserBaseDetailsImpl implements CloudUserBaseDetails {


    private final CloudUserBase cloudUserBase;

    public final CloudUserExtend cloudUserExtend;

    public CloudUserBaseDetailsImpl(CloudUserBase cloudUserBase, CloudUserExtend cloudUserExtend) {
        this.cloudUserBase = cloudUserBase;
        this.cloudUserExtend = cloudUserExtend;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        CollUtil.emptyIfNull(cloudUserExtend.getUserRoleCodes()).stream().map(RoleGrantedAuthority::new).forEach(authorityList::add);
        CollUtil.emptyIfNull(cloudUserExtend.getUserPermissions()).stream().map(RoleGrantedAuthority::new).forEach(authorityList::add);
        return authorityList;
    }

    @Override
    public String getPassword() {
        return cloudUserBase.getPassword();
    }

    @Override
    public List<String> getUserPermissions() {
        return cloudUserExtend.getUserPermissions();
    }

    @Override
    public List<String> getUserRoleCodes() {
        return cloudUserExtend.getUserRoleCodes();
    }


    @Override
    public String getId() {
        return cloudUserBase.getId();
    }

    @Override
    public String getUsername() {
        return cloudUserBase.getUsername();
    }

    @Override
    public String getRealName() {
        return cloudUserBase.getRealName();
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
