package com.pai.camel.examples.helper;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MyCamelContext {

    RouteBuilder routeBuilder;

    public MyCamelContext(RouteBuilder builder) {
        routeBuilder = builder;
    }

    public void run() {
        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(routeBuilder);
            camelContext.start();
            Thread.sleep(30 * 1000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
