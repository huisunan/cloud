package io.github.hsn.cloud.sys.biz.rpc;

import cn.hutool.core.bean.BeanUtil;
import io.github.hsn.cloud.common.api.bean.common.CloudUserExtend;
import io.github.hsn.cloud.common.api.bean.common.CloudUserExtendImpl;
import io.github.hsn.cloud.common.api.bean.common.CloudUserBaseImpl;
import io.github.hsn.cloud.sys.api.bean.entity.SysUser;
import io.github.hsn.cloud.sys.base.service.SysUserService;
import io.github.hsn.cloud.common.api.bean.common.CloudUserBase;
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
    public CloudUserBase getCloudUserByUsername(String username) {
        return sysUserService.lambdaQuery()
                .eq(SysUser::getUsername, username)
                .oneOpt()
                .map(sysUser -> BeanUtil.copyProperties(sysUser, CloudUserBaseImpl.class))
                .orElse(null);
    }

    @Override
    public CloudUserExtend getCloudUserExtendByUsername(String username) {
        return new CloudUserExtendImpl();
    }
}
