package com.pai.camel.examples.helper;

import com.pai.camel.examples.helper.ErrorHandler;
import com.pai.camel.examples.helper.MyException;
import com.pai.camel.examples.helper.MyProcessor;
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
