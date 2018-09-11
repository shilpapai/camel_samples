package com.pai.camel.examples.helper;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ErrorHandler implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
        System.out.println("Exception handling for :" + body);
    }
}
