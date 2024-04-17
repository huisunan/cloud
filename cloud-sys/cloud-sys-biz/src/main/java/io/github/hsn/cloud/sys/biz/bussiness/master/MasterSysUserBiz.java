package io.github.hsn.cloud.sys.biz.bussiness.master;

import io.github.hsn.cloud.common.core.security.SecurityUtils;
import io.github.hsn.cloud.sys.api.bean.vo.CurrentUserInfo;
import io.github.hsn.cloud.sys.biz.bussiness.SysUserBiz;
import org.springframework.stereotype.Service;

@Service
public class MasterSysUserBiz implements SysUserBiz {
    @Override
    public CurrentUserInfo currentUserInfo() {

        return SecurityUtils.getUserOpt()
                .map(user -> {
                    CurrentUserInfo currentUserInfo = new CurrentUserInfo();
                    currentUserInfo.setId(user.getId());
                    currentUserInfo.setUsername(user.getUsername());
                    currentUserInfo.setRealName(user.getRealName());
                    currentUserInfo.setRoleCodes(user.getUserRoleCodes());
                    currentUserInfo.setPermissions(user.getUserPermissions());
                    return currentUserInfo;
                })
                .orElse(null);
    }
}
