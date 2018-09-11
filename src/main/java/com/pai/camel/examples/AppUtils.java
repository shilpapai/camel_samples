package com.pai.camel.examples;

public class AppUtils {

    public static String getRabbitMqUri(String queue) {
        String uri = "rabbitmq://localhost:5672/direct?autoDelete=false&durable=true" +
                "&routingKey=" + queue + "&queue=" + queue + "&threadPoolSize=3&username=guest&password=guest" +
                "&vhost=/&exchangeType=direct&prefetchEnabled=true&prefetchSize=1&prefetchCount=1&" +
                "concurrentConsumers=3";
        return uri;
    }
}
