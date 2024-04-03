package io.github.hsn.cloud.common.core.security;

import io.github.hsn.cloud.common.api.bean.common.CloudUser;
import io.github.hsn.cloud.common.api.bean.common.CloudUserBase;

public interface SecurityJwtTokenInfoProvider {
    CloudUser getCloudUser();
}
