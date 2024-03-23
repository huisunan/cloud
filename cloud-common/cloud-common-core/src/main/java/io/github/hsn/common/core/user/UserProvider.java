package io.github.hsn.common.core.user;

import io.github.hsn.common.api.bean.common.CloudUser;

public interface UserProvider {
    CloudUser getByUserAccount(String userAccount);
}
