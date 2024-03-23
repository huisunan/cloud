package io.github.hsn.cloud.upms.biz.rpc;

import io.github.hsn.common.api.bean.common.CloudUser;
import io.github.hsn.common.core.user.UserProvider;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class UserProviderImpl implements UserProvider {
    @Override
    public CloudUser getByUserAccount(String userAccount) {
        CloudUser cloudUser = new CloudUser();
        cloudUser.setUserAccount("123");
        return cloudUser;
    }
}
