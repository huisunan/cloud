package io.github.hsn.cloud.common.core.tenant;

import io.github.hsn.cloud.common.api.bean.common.Tenant;

public interface TenantProvider {
    Tenant getById(String id);
}
