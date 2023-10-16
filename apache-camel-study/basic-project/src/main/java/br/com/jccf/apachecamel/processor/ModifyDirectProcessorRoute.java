package br.com.jccf.apachecamel.processor;

import org.apache.camel.builder.RouteBuilder;

public class ModifyDirectProcessorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:modifyInput")
                .log("Body message is ${body} and headers are ${headers}")
                .process(new ModifyDirectProcessor())
                .log("Body message is ${body} and headers are ${headers}")
                .to("file:data/modifyOutput?fileName=output.txt");
    }
}
