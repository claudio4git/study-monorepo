package br.com.jccf.apachecamel.processor;

import org.apache.camel.builder.RouteBuilder;

public class SampleProcessorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Body message is ${body} and headers are ${headers}")
                .process(new SampleProcessor())
                .to("file:data/output?fileName=output.txt");
    }
}
