package io.github.hsn.cloud.upms.biz.rpc;

import io.github.hsn.cloud.upms.base.service.SysTenantService;
import io.github.hsn.cloud.common.api.bean.common.Tenant;
import io.github.hsn.cloud.common.core.tenant.TenantProvider;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class TenantProviderImpl implements TenantProvider {
     @Resource
    private SysTenantService sysTenantService;

    @Override
    public Tenant getById(String id) {
        return sysTenantService.getOptById(id)
                .map(tenant -> {
                    Tenant t = new Tenant();
                    t.setId(id);
                    t.setName(tenant.getName());
                    t.setCode(tenant.getCode());
                    return t;
                })
                .orElse(null);
    }
}
