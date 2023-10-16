package br.com.jccf.apachecamel.mock;

import org.apache.camel.builder.RouteBuilder;

public class SampleMockRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Body message id ${body} and headers are ${headers}")
                .to("mock:data/mockOutput");
    }
}
