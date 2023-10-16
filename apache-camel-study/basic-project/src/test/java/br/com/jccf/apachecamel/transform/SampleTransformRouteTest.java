package br.com.jccf.apachecamel.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

public class SampleTransformRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleTransformRoute();
    }

    @Test
    public void transformRoute() {
        String expected = "123*345";
        String input = "123,345";

        String output = template.requestBody("direct:transformInput", input).toString();

        Assert.assertEquals(output, expected);
    }

    @Test
    public void transformMockRoute() throws InterruptedException {
        String expected = "123*345";
        String input = "123,345";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:transformInput", input);

        assertMockEndpointsSatisfied();
    }

}