package io.github.hsn.common.api.bean.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Tenant implements Serializable {
    @Serial
    private static final long serialVersionUID = -5921612330777973340L;


    private String id;

    private String name;

    private String code;
}
