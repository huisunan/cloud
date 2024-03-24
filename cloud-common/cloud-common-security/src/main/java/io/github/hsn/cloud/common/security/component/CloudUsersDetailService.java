package io.github.hsn.cloud.common.security.component;

import io.github.hsn.cloud.common.core.user.UserProvider;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CloudUsersDetailService implements UserDetailsService {

    @Resource
    private UserProvider userProvider;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CloudUserDetails(userProvider.getByUserAccount(username));
    }
}
