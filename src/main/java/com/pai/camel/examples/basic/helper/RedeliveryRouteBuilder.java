package com.pai.camel.examples.basic.helper;

import org.apache.camel.builder.RouteBuilder;

public class RedeliveryRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(MyException.class).process(new ErrorHandler()).maximumRedeliveries(2).redeliveryDelay(10).handled(true);

        from("file:/Users/shilpapai/Desktop/from?noop=true")
                .process(new MyProcessor())
                .to("file:/Users/shilpapai/Desktop/to");
    }
}
