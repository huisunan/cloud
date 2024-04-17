package io.github.hsn.cloud.common.security.detail;

import io.github.hsn.cloud.common.api.bean.common.CloudUserBase;
import io.github.hsn.cloud.common.api.bean.common.CloudUserExtend;
import io.github.hsn.cloud.common.api.constants.CacheConstants;
import io.github.hsn.cloud.common.core.tenant.TenantUtil;
import io.github.hsn.cloud.common.core.user.UserProvider;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@NoArgsConstructor
@AllArgsConstructor
public class CloudUsersDetailService implements UserDetailsService {

    @Resource
    private UserProvider userProvider;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public CloudUserBaseDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CloudUserBaseDetailsImpl(getCloudUserBase(username), getCloudUserExtend(username));
    }


    protected CloudUserBase getCloudUserBase(String username) {
        RBucket<CloudUserBase> userBucket = redissonClient.getBucket(TenantUtil.getTenantCacheKey(CacheConstants.USER_BASE, username));
        if (userBucket.get() == null) {
            CloudUserBase cloudUserBaseByAccount = userProvider.getCloudUserByUsername(username);
            userBucket.set(cloudUserBaseByAccount);
            return cloudUserBaseByAccount;
        }
        return userBucket.get();
    }

    protected CloudUserExtend getCloudUserExtend(String username) {
        RBucket<CloudUserExtend> bucket = redissonClient.getBucket(TenantUtil.getTenantCacheKey(CacheConstants.USER_EXTEND, username));
        if (bucket.get() == null) {
            CloudUserExtend cloudUserExtend = userProvider.getCloudUserExtendByUsername(username);
            bucket.set(cloudUserExtend);
            return cloudUserExtend;
        }
        return bucket.get();
    }
}
