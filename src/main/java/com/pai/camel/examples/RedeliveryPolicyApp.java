package com.pai.camel.examples;

import com.pai.camel.examples.helper.ErrorHandler;
import com.pai.camel.examples.helper.MyCamelContext;
import com.pai.camel.examples.helper.MyException;
import com.pai.camel.examples.helper.MyProcessor;
import org.apache.camel.builder.RouteBuilder;

public class RedeliveryPolicyApp {
    public static void main(String[] args) {
        new MyCamelContext(new RedeliveryRouteBuilder()).run();
    }
}

class RedeliveryRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(MyException.class).process(new ErrorHandler()).maximumRedeliveries(2).redeliveryDelay(10).handled(true);

        from("file:/Users/shilpapai/Desktop/from?noop=true")
                .process(new MyProcessor())
                .to("file:/Users/shilpapai/Desktop/to");
    }
}
