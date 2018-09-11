package com.pai.camel.examples;

import com.pai.camel.examples.helper.MyCamelContext;
import com.pai.camel.examples.helper.RouteBuilderWithTryCatch;

public class ExceptionHandling {

    public static void main(String[] args) {

        new MyCamelContext(new RouteBuilderWithTryCatch()).run();
        //new MyCamelContext(new RouteBuildersWithOnExceptionHandler()).run();
    }
}


