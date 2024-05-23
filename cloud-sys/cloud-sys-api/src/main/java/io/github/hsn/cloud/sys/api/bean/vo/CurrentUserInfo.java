package io.github.hsn.cloud.sys.api.bean.vo;

import lombok.Data;

import java.util.Collection;

/**
 * 当前用户信息
 */
@Data
public class CurrentUserInfo {

    private String id;

    private String username;

    private String realName;

    private Collection<String> roleCodes;

    private Collection<String> permissions;
}
