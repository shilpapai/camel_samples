package com.pai.camel.examples.basic;

import com.pai.camel.examples.MyCamelContext;
import com.pai.camel.examples.basic.helper.RedeliveryRouteBuilder;

public class RedeliveryPolicyApp {
    public static void main(String[] args) {
        new MyCamelContext(new RedeliveryRouteBuilder()).run();
    }
}

