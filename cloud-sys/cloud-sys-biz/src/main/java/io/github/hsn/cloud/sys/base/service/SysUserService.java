package io.github.hsn.cloud.sys.base.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.hsn.cloud.sys.api.bean.entity.SysUser;
import io.github.hsn.cloud.sys.base.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {
}
