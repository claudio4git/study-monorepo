package br.com.jccf.apachecamel.transform;

import org.apache.camel.builder.RouteBuilder;

public class SampleTransformRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:transformInput")
                .transform(body().regexReplaceAll(",", "*"))
                .to("mock:output");
    }
}
