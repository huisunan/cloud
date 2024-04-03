package io.github.hsn.cloud.common.data.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.github.hsn.cloud.common.core.security.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 填写元对象字段值
 * 创建时间，创建人姓名，创建人id
 * 更新时间，更新人姓名，更新人id
 */
public class CloudMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "createUserId", SecurityUtils::getUserId, String.class);
        this.strictInsertFill(metaObject, "createUserRealName", SecurityUtils::getRealName, String.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updateUserId", SecurityUtils::getUserId, String.class);
        this.strictUpdateFill(metaObject, "updateUserRealName", SecurityUtils::getRealName, String.class);
    }
}
