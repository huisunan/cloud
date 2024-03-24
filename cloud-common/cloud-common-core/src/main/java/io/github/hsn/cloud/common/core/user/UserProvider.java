package io.github.hsn.cloud.common.core.user;

import io.github.hsn.cloud.common.api.bean.common.CloudUser;

public interface UserProvider {
    CloudUser getByUserAccount(String userAccount);
}
