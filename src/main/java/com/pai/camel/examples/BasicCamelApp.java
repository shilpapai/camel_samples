package com.pai.camel.examples;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class BasicCamelApp {

    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:/Users/shilpapai/Desktop/from?noop=true")
                            .to("file:/Users/shilpapai/Desktop/to");
                }
            });
            camelContext.start();
            Thread.sleep(5 * 1000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
