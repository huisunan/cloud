package io.github.hsn.cloud.upms.base.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.hsn.cloud.upms.api.bean.entity.SysTenant;
import io.github.hsn.cloud.upms.base.mapper.SysTenantMapper;
import org.springframework.stereotype.Service;

@Service
public class SysTenantService extends ServiceImpl<SysTenantMapper, SysTenant> {
}
