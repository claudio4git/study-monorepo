package br.com.jccf.apachecamel.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Body message is ${body} and headers are ${headers}")
                .to("file:data/sampleOutput?fileName=output.txt");
    }
}
