package io.github.hsn.cloud.common.api.constants;

import cn.hutool.core.util.StrUtil;

public interface CacheConstants {

    String SPLIT = StrUtil.COLON;

    String GLOBAL = "gl";
    String GLOBALLY = GLOBAL + SPLIT;

    String TENANT = GLOBALLY + "tenant_v1";

    String AUTH_TOKEN = "auth:token";

    String USER_TOKEN = "user:token";
}
