package io.github.hsn.cloud.upms.api.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.hsn.common.api.bean.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("upms.sys_tenant")
public class SysTenant extends BaseEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String tenantId;

    private String name;

    private String code;
}
