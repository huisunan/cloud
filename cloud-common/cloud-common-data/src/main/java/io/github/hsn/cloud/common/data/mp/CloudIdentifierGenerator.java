package io.github.hsn.cloud.common.data.mp;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.github.f4b6a3.ulid.Ulid;

public class CloudIdentifierGenerator implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity) {
        return Ulid.fast().toString();
    }
}
