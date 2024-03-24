package io.github.hsn.cloud.common.core.security;

import io.github.hsn.cloud.common.api.bean.common.JwtTokenInfo;

public interface SecurityJwtTokenInfoProvider {
    JwtTokenInfo jwtTokenInfo();
}
