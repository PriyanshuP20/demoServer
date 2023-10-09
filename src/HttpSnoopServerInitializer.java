

//import java.nio.channels.SocketChannel;
import io.netty.channel.socket.SocketChannel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpSnoopServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();

        // Add the HTTP codec for encoding/decoding HTTP messages
        pipeline.addLast(new HttpServerCodec());

        // Add the HTTP object aggregator to simplify handling of HTTP messages
        pipeline.addLast(new HttpObjectAggregator(65536)); // Adjust buffer size as needed

        // Add your custom HTTP request handler
        pipeline.addLast(new HttpSnoopServerHandler());
    }
}
