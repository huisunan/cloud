package io.github.hsn.cloud.sys.biz.controller;

import io.github.hsn.cloud.sys.api.bean.entity.SysUser;
import io.github.hsn.cloud.sys.base.mapper.SysUserMapper;
import io.github.hsn.cloud.common.api.bean.vo.R;
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
        return R.success();
    }

    @DeleteMapping("{id}")
    public R<SysUser> delete(String id) {
        sysUserMapper.deleteById(id);
        return R.success();
    }
}
