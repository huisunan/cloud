package io.github.hsn.cloud.common.api.bean.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 基础entity
 */
@Data
public class BaseEntity {


    @ApiModelProperty("租户id")
    protected String tenantId;

    @TableField(fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NEVER)
    @ApiModelProperty("创建时间")
    protected LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NEVER)
    @ApiModelProperty("用户id")
    protected String createUserId;

    @TableField(fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NEVER)
    @ApiModelProperty("创建用户名")
    protected String createUserRealName;


    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty("更新时间")
    protected LocalDateTime updateTime;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty("更新人id")
    protected String updateUserId;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty("更新人名称")
    protected String updateUserRealName;


    @ApiModelProperty("逻辑删除标识")
    protected String delFlag;

}
