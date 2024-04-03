package io.github.hsn.cloud.common.api.constants;

import cn.hutool.core.util.StrUtil;

public interface CacheConstants {

    String SPLIT = StrUtil.COLON;

    String GLOBAL = "gl";
    String GLOBALLY = GLOBAL + SPLIT;

    String TENANT = GLOBALLY + "tenant_v1";

    String USER_BASE = "user:base";

    String USER_EXTEND = "user:extends";
}
