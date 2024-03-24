package io.github.hsn.cloud.common.api.bean.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CloudUser implements Serializable {

    @Serial
    private static final long serialVersionUID = -562923848362048510L;

    private String id;

    private String username;

    private String realName;

    private String password;

}
