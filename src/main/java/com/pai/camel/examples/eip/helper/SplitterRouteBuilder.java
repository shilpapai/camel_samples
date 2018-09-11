package com.pai.camel.examples.eip.helper;

import org.apache.camel.builder.RouteBuilder;

/**
 * The Splitter from the EIP patterns allows
 * users split a message into a number of pieces and process them individually.
 */


public class SplitterRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/shilpapai/Desktop/input?noop=true")
                .split().tokenize("\n")
                .to("rabbitmq://localhost:5672/direct?autoDelete=false&durable=true" +
                        "&routingKey=test_queue&queue=test_queue&threadPoolSize=3&username=guest&password=guest" +
                        "&vhost=/&exchangeType=direct&prefetchEnabled=true&prefetchSize=1&prefetchCount=1&" +
                        "concurrentConsumers=3");
    }
}
