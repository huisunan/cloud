package io.github.hsn.cloud.upms.biz.controller;

import cn.hutool.core.util.RandomUtil;
import io.github.hsn.cloud.upms.api.bean.entity.SysUser;
import io.github.hsn.cloud.upms.base.mapper.SysUserMapper;
import io.github.hsn.common.api.bean.common.Tenant;
import io.github.hsn.common.api.bean.vo.R;
import io.github.hsn.common.core.tenant.TenantUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("sys/user")
public class SysUserController {

    @Resource
    private SysUserMapper sysUserMapper;


    @GetMapping("current")
    public R<SysUser> current() {
        Tenant currentTenant = TenantUtil.getCurrentTenant();
        log.info(TenantUtil.getCurrentTenantId());
        SysUser sysUser = new SysUser();
        sysUser.setUserAccount(RandomUtil.randomString(12));
        sysUserMapper.insert(sysUser);
        return R.success(sysUser);
    }

    @DeleteMapping("{id}")
    public R<SysUser> delete(String id) {
        sysUserMapper.deleteById(id);
        return R.success();
    }
}
