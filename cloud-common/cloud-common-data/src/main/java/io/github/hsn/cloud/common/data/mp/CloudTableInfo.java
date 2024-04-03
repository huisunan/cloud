package io.github.hsn.cloud.common.data.mp;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.session.Configuration;

public class CloudTableInfo extends TableInfo {
    /**
     * @param configuration 配置对象
     * @param entityType    实体类型
     * @since 3.4.4
     */
    public CloudTableInfo(Configuration configuration, Class<?> entityType) {
        super(configuration, entityType);
    }

    /**
     * 获取逻辑删除条件
     * where条件拼接 delFlag = 0
     * 删除时，将delFlag赋值为id
     * @param isWhere 是否为 where 条件
     * @return sql 片段
     */
    @Override
    protected String formatLogicDeleteSql(boolean isWhere) {
        TableFieldInfo logicDeleteFieldInfo = getLogicDeleteFieldInfo();

        if (isWhere) {
            String value = logicDeleteFieldInfo.getLogicNotDeleteValue();
            if (NULL.equalsIgnoreCase(value)) {
                return logicDeleteFieldInfo.getColumn() + " IS NULL";
            } else {
                return logicDeleteFieldInfo.getColumn() + EQUALS + String.format(logicDeleteFieldInfo.isCharSequence() ? "'%s'" : "%s", value);
            }
        }
        String value = logicDeleteFieldInfo.getLogicDeleteValue();
        final String targetStr = logicDeleteFieldInfo.getColumn() + EQUALS;
        if (NULL.equalsIgnoreCase(value)) {
            return targetStr + NULL;
        } else {
            return targetStr + getKeyColumn();
        }
    }
}
