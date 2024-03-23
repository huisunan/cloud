package io.github.hsn.common.core.tenant;

import io.github.hsn.common.api.bean.common.Tenant;

public interface TenantProvider {
    Tenant getById(String id);
}
