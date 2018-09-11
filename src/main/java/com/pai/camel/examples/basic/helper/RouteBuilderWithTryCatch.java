package com.pai.camel.examples.basic.helper;

import org.apache.camel.builder.RouteBuilder;

public class RouteBuilderWithTryCatch extends RouteBuilder {
    @Override
    public void configure() {

        // dotry and do catch applicable only for one route
        from("file:/Users/shilpapai/Desktop/from?noop=true")
                .doTry()
                .process(new MyProcessor())
                .doCatch(MyException.class)
                .process(new ErrorHandler())
                .to("file:/Users/shilpapai/Desktop/to");
    }
}
