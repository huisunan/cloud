package io.github.hsn.cloud.common.api.bean.common;

import lombok.Data;

import java.util.List;

@Data
public class CloudUserExtendImpl implements CloudUserExtend {


    protected List<String> userRoleCodes;

    protected List<String> userPermissions;


}
