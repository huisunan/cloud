package io.github.hsn.cloud.upms.api.bean.vo;

import lombok.Data;

import java.util.Collection;

@Data
public class CurrentUserInfo {

    private String id;

    private String username;

    private String realName;

    private Collection<String> roleCodes;

    private Collection<String> permissions;
}
