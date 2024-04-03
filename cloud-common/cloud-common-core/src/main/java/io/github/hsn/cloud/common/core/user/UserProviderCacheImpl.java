package io.github.hsn.cloud.common.core.user;

import io.github.hsn.cloud.common.api.bean.common.CloudUserBase;
import io.github.hsn.cloud.common.api.bean.common.CloudUserExtend;
import io.github.hsn.cloud.common.api.constants.CacheConstants;
import io.github.hsn.cloud.common.core.tenant.TenantUtil;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

@RequiredArgsConstructor
public class UserProviderCacheImpl implements UserProvider {
    private final UserProvider userProvider;

    private final RedissonClient redissonClient;

    @Override
    public CloudUserBase getCloudUserByUsername(String username) {
        RBucket<CloudUserBase> userBucket = redissonClient.getBucket(TenantUtil.getTenantCacheKey(CacheConstants.USER_BASE, username));
        if (userBucket.get() == null) {
            CloudUserBase cloudUserBaseByAccount = userProvider.getCloudUserByUsername(username);
            userBucket.set(cloudUserBaseByAccount);
            return cloudUserBaseByAccount;
        }
        return userBucket.get();
    }


    @Override
    public CloudUserExtend getCloudUserExtendByUsername(String username) {
        //获取缓存
        RBucket<CloudUserExtend> bucket = redissonClient.getBucket(TenantUtil.getTenantCacheKey(CacheConstants.USER_EXTEND, username));
        if (bucket.get() == null) {
            CloudUserExtend cloudUserExtend = userProvider.getCloudUserExtendByUsername(username);
            bucket.set(cloudUserExtend);
            return cloudUserExtend;
        }
        return bucket.get();
    }
}
