package io.github.hsn.cloud.common.core.redisson;

import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;
import org.redisson.codec.CompositeCodec;
import org.redisson.codec.MsgPackJacksonCodec;

/**
 *  msgpack + jackson
 */
public class CloudMsgPackJacksonCodec extends CompositeCodec {
    private static final MsgPackJacksonCodec MSG_PACK_JACKSON_CODEC = new MsgPackJacksonCodec();

    public static final CloudMsgPackJacksonCodec INSTANCE = new CloudMsgPackJacksonCodec();




    private CloudMsgPackJacksonCodec() {
        super(StringCodec.INSTANCE, MSG_PACK_JACKSON_CODEC, MSG_PACK_JACKSON_CODEC);
    }
}
