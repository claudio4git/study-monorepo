package br.com.jccf.apachecamel.bean;

import org.apache.camel.builder.RouteBuilder;

public class SampleBeanRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Body message is ${body}")
                .bean(new SampleBean(), "map")
                .log("Body message is ${body}")
                .to("mock:output");
    }
}
