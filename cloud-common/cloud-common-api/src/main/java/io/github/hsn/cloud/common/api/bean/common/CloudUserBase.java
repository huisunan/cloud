package io.github.hsn.cloud.common.api.bean.common;

import java.io.Serializable;

public interface CloudUserBase extends Serializable {
    String getId();

    String getUsername();

    String getRealName();

    String getPassword();

}
