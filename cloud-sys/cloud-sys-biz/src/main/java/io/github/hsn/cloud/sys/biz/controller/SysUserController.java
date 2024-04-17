package io.github.hsn.cloud.sys.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.hsn.cloud.sys.api.bean.entity.SysUser;
import io.github.hsn.cloud.sys.base.mapper.SysUserBaseMapper;
import io.github.hsn.cloud.common.api.bean.vo.R;
import io.github.hsn.cloud.sys.base.service.SysUserService;
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
    private SysUserBaseMapper sysUserMapper;

    @Resource
    private SysUserService sysUserService;


    @GetMapping("current")
    public R<SysUser> current() {
        return R.success();
    }

    @GetMapping
    public R<IPage<SysUser>> page(Page<SysUser> page) {
        return R.success(sysUserService.page(page));
    }

    @DeleteMapping("{id}")
    public R<SysUser> delete(String id) {
        sysUserMapper.deleteById(id);
        return R.success();
    }
}
