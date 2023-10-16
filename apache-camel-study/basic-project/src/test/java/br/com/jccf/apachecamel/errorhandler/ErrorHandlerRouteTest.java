package br.com.jccf.apachecamel.errorhandler;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ErrorHandlerRoute();
    }


    @Test(expected = RuntimeException.class)
    public void errorHandlerTest() {

        String expected = "abc";

        String input = null;

        String output = template.requestBody("direct:exception", input, String.class);

        assertEquals(expected, output);
    }
}