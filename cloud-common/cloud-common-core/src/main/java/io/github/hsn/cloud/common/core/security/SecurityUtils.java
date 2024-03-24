package io.github.hsn.cloud.common.core.security;


import io.github.hsn.cloud.common.api.bean.common.CloudUser;

import java.util.Optional;

public class SecurityUtils {

    public static SecurityJwtTokenInfoProvider securityJwtTokenInfoProvider;

    public static CloudUser getUser() {
        return Optional.ofNullable();
    }

    public static String getUserId() {
        return getUserOpt().map(CloudUser::getId).orElse(null);
    }

    public static String getRealName() {
        return getUserOpt().map(CloudUser::getRealName).orElse(null);
    }

    public static Optional<CloudUser> getUserOpt() {
        return Optional.ofNullable(getUser());
    }

}
