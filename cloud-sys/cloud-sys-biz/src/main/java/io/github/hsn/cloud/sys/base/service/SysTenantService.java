package io.github.hsn.cloud.sys.base.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.hsn.cloud.sys.api.bean.entity.SysTenant;
import io.github.hsn.cloud.sys.base.mapper.SysTenantMapper;
import org.springframework.stereotype.Service;

@Service
public class SysTenantService extends ServiceImpl<SysTenantMapper, SysTenant> {
}
