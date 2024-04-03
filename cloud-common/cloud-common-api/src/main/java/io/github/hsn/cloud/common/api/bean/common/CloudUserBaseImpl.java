package io.github.hsn.cloud.common.api.bean.common;

import lombok.Data;

@Data
public class CloudUserBaseImpl implements CloudUserBase {
    protected String id;
    protected String username;
    protected String realName;
    protected String password;

}
