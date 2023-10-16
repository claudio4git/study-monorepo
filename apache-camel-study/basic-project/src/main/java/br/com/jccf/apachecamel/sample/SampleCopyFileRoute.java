package br.com.jccf.apachecamel.sample;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

public class SampleCopyFileRoute {

    private static final Logger LOGGER = Logger.getLogger(SampleCopyFileRoute.class);

    public static void main(String[] args) {

        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("file:data/input?noop=true")
                            .to("file:data/output");
                }
            });

            camelContext.start();

            Thread.sleep(5000); // 5 seconds

            camelContext.stop();
        } catch (Exception e) {
            LOGGER.error("Exception is " + e);
        }
    }
}
