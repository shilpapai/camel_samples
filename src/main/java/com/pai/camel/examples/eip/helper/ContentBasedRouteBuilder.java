package com.pai.camel.examples.eip.helper;

import com.pai.camel.examples.AppUtils;
import org.apache.camel.builder.RouteBuilder;

/**
 * The Content-Based Router inspects the content of a message and routes it to
 * another channel based on the content of the message. Using such a router enables
 * the message producer to send messages to a single channel and leave it to the
 * Content-Based Router to inspect messages and route them to the proper destination.
 * This alleviates the sending application from this task and avoids coupling
 * the message producer to specific destination channels.
 */
public class ContentBasedRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("file:/Users/shilpapai/Desktop/input?noop=true")
                .split().tokenize("\n")
                .choice()
                .when(body().contains("rabbit"))
                .to(AppUtils.getRabbitMqUri("rabbit"))
                .when(body().contains("camel"))
                .to(AppUtils.getRabbitMqUri("camel"))
                .otherwise()
                .to(AppUtils.getRabbitMqUri("others"));
    }

}
