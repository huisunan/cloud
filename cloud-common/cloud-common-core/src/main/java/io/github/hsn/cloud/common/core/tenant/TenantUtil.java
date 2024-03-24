package io.github.hsn.cloud.common.core.tenant;

import cn.hutool.core.util.StrUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import io.github.hsn.cloud.common.api.bean.common.Tenant;
import io.github.hsn.cloud.common.api.constants.CacheConstants;
import jakarta.annotation.Resource;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
public class TenantUtil {
    private static final ThreadLocal<String> TENANT_TTL = new TransmittableThreadLocal<>();

    public static RedissonClient redissonClient;

    public static TenantProvider tenantProvider;

    /**
     * 获取当前租户信息
     *
     * @return 租户信息
     */
    public static String getCurrentTenantId() {
        return TENANT_TTL.get();
    }

    public static void clear() {
        TENANT_TTL.remove();
    }

    public static void setTenantId(String tenantId) {
        TENANT_TTL.set(tenantId);
    }


    public static Tenant getCurrentTenant() {
        if (StrUtil.isBlank(getCurrentTenantId())) {
            return null;
        }
        RMap<String, Tenant> cacheMap = redissonClient.getMap(CacheConstants.TENANT);
        return cacheMap.computeIfAbsent(
                getCurrentTenantId(),
                key -> tenantProvider.getById(getCurrentTenantId())
        );
    }

    public static String getTenantCacheKey(String... keys) {
        return getCurrentTenantId() + CacheConstants.SPLIT + String.join(CacheConstants.SPLIT, keys);
    }


    @Resource
    public void setRedissonClient(RedissonClient redissonClient) {
        TenantUtil.redissonClient = redissonClient;
    }

    @Resource
    public void setTenantProvider(TenantProvider tenantProvider) {
        TenantUtil.tenantProvider = tenantProvider;
    }
}
