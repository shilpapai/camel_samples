package com.pai.camel.examples.eip.helper;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import static com.pai.camel.examples.AppUtils.getRabbitMqUri;

/**
 * Wire Tap allows you to route messages to a separate location while they are being forwarded to the ultimate destination.

 */
public class WireTapRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/shilpapai/Desktop/input/?fileName=number.txt&noop=true")
                .split().tokenize("\n").to("direct:test");

        from("direct:test")
                .wireTap(getRabbitMqUri("DeadLetterQueue"))
                .filter(body().contains("one"))
                .to(getRabbitMqUri("test"));
    }
}
