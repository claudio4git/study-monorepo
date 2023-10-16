package br.com.jccf.apachecamel.processor;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

public class ModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ModifyDirectProcessorRoute();
    }

    @Test
    public void modifyDirectProcessor() {
        String expected = "123:345";
        String input = "123,345";

        String output = template.requestBody("direct:modifyInput", input).toString();

        Assert.assertEquals(expected, output);
    }
}