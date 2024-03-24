package io.github.hsn.cloud.common.data.mp;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import io.github.hsn.cloud.common.core.tenant.TenantUtil;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.StringValue;

public class CloudTenantLineHandler implements TenantLineHandler {
    @Override
    public Expression getTenantId() {
        String currentTenantId = TenantUtil.getCurrentTenantId();
        if (currentTenantId == null) {
            return new NullValue();
        }
        return new StringValue(currentTenantId);
    }
}
