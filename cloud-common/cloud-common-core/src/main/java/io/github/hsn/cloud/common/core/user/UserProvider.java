package io.github.hsn.cloud.common.core.user;

import io.github.hsn.cloud.common.api.bean.common.CloudUserBase;
import io.github.hsn.cloud.common.api.bean.common.CloudUserExtend;

public interface UserProvider {
    CloudUserBase getCloudUserByUsername(String username);

    CloudUserExtend getCloudUserExtendByUsername(String username);
}
