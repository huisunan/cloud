package io.github.hsn.cloud.sys.api.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.hsn.cloud.common.api.bean.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_user",schema = "upms")
public class SysUser extends BaseEntity {

    @ApiModelProperty("id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    private String mobile;
}
