package io.github.hsn.cloud.common.api.bean.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 5456582292552847204L;

    private String id;

    private String username;

}
