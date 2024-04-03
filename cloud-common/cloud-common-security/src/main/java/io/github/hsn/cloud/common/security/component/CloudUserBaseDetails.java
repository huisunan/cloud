package io.github.hsn.cloud.common.security.component;

import io.github.hsn.cloud.common.api.bean.common.CloudUser;
import io.github.hsn.cloud.common.api.bean.common.CloudUserBase;
import io.github.hsn.cloud.common.api.bean.common.CloudUserExtend;
import org.springframework.security.core.userdetails.UserDetails;

public interface CloudUserBaseDetails extends UserDetails, CloudUser {
}
