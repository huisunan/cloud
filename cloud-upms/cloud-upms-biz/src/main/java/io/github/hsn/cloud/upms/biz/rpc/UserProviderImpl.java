package io.github.hsn.cloud.upms.biz.rpc;

import cn.hutool.core.bean.BeanUtil;
import io.github.hsn.cloud.upms.api.bean.entity.SysUser;
import io.github.hsn.cloud.upms.base.service.SysUserService;
import io.github.hsn.cloud.common.api.bean.common.CloudUser;
import io.github.hsn.cloud.common.core.user.UserProvider;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class UserProviderImpl implements UserProvider {

    @Resource
    private SysUserService sysUserService;

    @Override
    public CloudUser getByUserAccount(String userAccount) {

        return sysUserService.lambdaQuery()
                .eq(SysUser::getUsername, userAccount)
                .oneOpt()
                .map(sysUser -> BeanUtil.copyProperties(sysUser, CloudUser.class))
                .orElse(null);
    }
}
