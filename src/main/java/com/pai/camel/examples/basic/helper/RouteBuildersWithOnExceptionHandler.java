package com.pai.camel.examples.basic.helper;

import org.apache.camel.builder.RouteBuilder;

public class RouteBuildersWithOnExceptionHandler extends RouteBuilder {
    @Override
    public void configure() {

        // on exception applicable for all routes
        onException(MyException.class).process(new ErrorHandler()).handled(true);

        from("file:/Users/shilpapai/Desktop/from?noop=true")
                .process(new MyProcessor())
                .to("file:/Users/shilpapai/Desktop/to");

        from("file:/Users/shilpapai/Desktop/input?noop=true")
                .process(new MyProcessor())
                .to("file:/Users/shilpapai/Desktop/output");
    }
}
