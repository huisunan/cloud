package io.github.hsn.cloud.common.api.bean.common;

import java.io.Serializable;
import java.util.List;

public interface CloudUserExtend extends Serializable {

    /**
     * 获取权限
     */
    List<String> getUserPermissions();

    /**
     * 获取角色
     */
    List<String> getUserRoleCodes();
}
