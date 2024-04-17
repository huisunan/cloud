package io.github.hsn.cloud.sys.base.service;

import io.github.hsn.cloud.common.data.mp.base.CloudServiceImpl;
import io.github.hsn.cloud.sys.api.bean.entity.SysTenant;
import io.github.hsn.cloud.sys.base.mapper.SysTenantBaseMapper;
import org.springframework.stereotype.Service;

@Service
public class SysTenantService extends CloudServiceImpl<SysTenantBaseMapper, SysTenant> {
}
