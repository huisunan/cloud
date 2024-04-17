package io.github.hsn.cloud.sys.base.service;

import io.github.hsn.cloud.common.data.mp.base.CloudServiceImpl;
import io.github.hsn.cloud.sys.api.bean.entity.SysUser;
import io.github.hsn.cloud.sys.base.mapper.SysUserBaseMapper;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends CloudServiceImpl<SysUserBaseMapper, SysUser> {
}
