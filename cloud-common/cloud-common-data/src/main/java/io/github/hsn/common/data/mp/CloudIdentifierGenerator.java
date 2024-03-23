package io.github.hsn.common.data.mp;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.github.f4b6a3.ulid.Ulid;

public class CloudIdentifierGenerator extends DefaultIdentifierGenerator {

    @Override
    public String nextUUID(Object entity) {
        return Ulid.fast().toString();
    }
}
