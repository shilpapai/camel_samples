package com.pai.camel.examples.eip.helper;

import com.pai.camel.examples.AppUtils;
import org.apache.camel.builder.RouteBuilder;

/**
 * A Message Filter is a special form of a Content-Based Router.
 * It examines the message content and passes the message to another channel
 * if the message content matches certain criteria. Otherwise, it discards the message.
 */
public class MessageFilterRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/shilpapai/Desktop/input/?fileName=number.txt&noop=true")
                .split().tokenize("\n").to("direct:test");
        from("direct:test").filter(body().contains("one")).to(AppUtils.getRabbitMqUri("test"));
    }
}
