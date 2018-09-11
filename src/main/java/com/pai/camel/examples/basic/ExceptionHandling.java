package com.pai.camel.examples.basic;

import com.pai.camel.examples.MyCamelContext;
import com.pai.camel.examples.basic.helper.RouteBuilderWithTryCatch;

public class ExceptionHandling {

    public static void main(String[] args) {

        new MyCamelContext(new RouteBuilderWithTryCatch()).run();
        //new MyCamelContext(new RouteBuildersWithOnExceptionHandler()).run();
    }
}


