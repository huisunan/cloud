package io.github.hsn.cloud.common.security.detail;

import io.github.hsn.cloud.common.core.user.UserProvider;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@NoArgsConstructor
@AllArgsConstructor
public class CloudUsersDetailService implements UserDetailsService {

    @Resource
    private UserProvider userProvider;

    @Override
    public CloudUserBaseDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CloudUserBaseDetailsImpl(userProvider.getCloudUserByUsername(username), userProvider.getCloudUserExtendByUsername(username));
    }
}
