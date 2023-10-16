package br.com.jccf.apachecamel.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleBeanRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleBeanRoute();
    }

    @Test
    public void beanRoute() throws InterruptedException {
        String expected = "123*345";
        String input = "123,345";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:beanInput", input);

        assertMockEndpointsSatisfied();
    }
}