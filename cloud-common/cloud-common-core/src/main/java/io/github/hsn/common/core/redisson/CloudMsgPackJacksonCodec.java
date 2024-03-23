package io.github.hsn.common.core.redisson;

import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;
import org.redisson.codec.CompositeCodec;
import org.redisson.codec.MsgPackJacksonCodec;

public class CloudMsgPackJacksonCodec extends CompositeCodec {

    public CloudMsgPackJacksonCodec() {
        super(new StringCodec(), new MsgPackJacksonCodec());
    }
}
