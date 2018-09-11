package com.pai.camel.examples.helper;

import com.pai.camel.examples.helper.MyException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
        System.out.println("processing file : " + body);

        if (body.toString().contains("html")) {
            System.out.println("exception occured ");
            throw new MyException("Custom exception occured");
        }

    }
}
