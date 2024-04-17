package io.github.hsn.cloud.common.security.detail;

import io.github.hsn.cloud.common.api.bean.common.CloudUser;
import org.springframework.security.core.userdetails.UserDetails;

public interface CloudUserBaseDetails extends UserDetails, CloudUser {
}
