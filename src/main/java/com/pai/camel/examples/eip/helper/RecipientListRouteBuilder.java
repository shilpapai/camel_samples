package com.pai.camel.examples.eip.helper;

import com.pai.camel.examples.AppUtils;
import org.apache.camel.builder.RouteBuilder;

import static com.pai.camel.examples.AppUtils.*;

public class RecipientListRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/shilpapai/Desktop/input/?fileName=number.txt&noop=true")
                .split().tokenize("\n").to("direct:test");

        from("direct:test")
                .process(exchange -> {
                    String queue = getRabbitMqUri(exchange.getIn().getBody().toString());
                    exchange.getIn().setHeader("queue", queue);
                })
                .recipientList(header("queue"));
    }

}
