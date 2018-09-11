package com.pai.camel.examples.eip.helper;

import com.pai.camel.examples.basic.helper.MyException;
import org.apache.camel.builder.RouteBuilder;

public class EIPRouteBuilderFactory {

    public static RouteBuilder getRouteBuilder(CamelEIP eip) throws Exception {

        switch (eip) {
            case SPLITTER:
                return new SplitterRouteBuilder();
            case CONTENT_BASED:
                return new ContentBasedRouteBuilder();
            case RECIPIENT_LIST:
                return new RecipientListRouteBuilder();
            case MESSAGE_FILTER:
                return new MessageFilterRouteBuilder();
            case WIRE_TAP:
                return new WireTapRouteBuilder();
            default:
                throw new MyException("not supported eip " + eip);

        }
    }
}
