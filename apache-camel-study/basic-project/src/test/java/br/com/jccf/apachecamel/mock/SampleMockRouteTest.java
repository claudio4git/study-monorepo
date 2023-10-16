package br.com.jccf.apachecamel.mock;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport {


    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleMockRoute();
    }

    @Test
    public void mockRoute() throws InterruptedException {
        String input = "hello";

        MockEndpoint mock = getMockEndpoint("mock:data/mockOutput");
        mock.expectedBodiesReceived(input);

        template.sendBody("direct:sampleInput", "hello");
        assertMockEndpointsSatisfied();
    }
}