package com.pai.camel.examples.eip;

import com.pai.camel.examples.MyCamelContext;
import com.pai.camel.examples.eip.helper.CamelEIP;
import com.pai.camel.examples.eip.helper.EIPRouteBuilderFactory;
import org.apache.camel.builder.RouteBuilder;

public class EIPApp {

    public static void main(String[] args) {

        CamelEIP eip = CamelEIP.WIRE_TAP; // checkout more eip in CamelEIP
        RouteBuilder routeBuilder;
        try {
            routeBuilder = EIPRouteBuilderFactory.getRouteBuilder(eip);
            new MyCamelContext(routeBuilder).run();
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
        }
    }
}
