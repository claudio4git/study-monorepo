package br.com.jccf.apachecamel.json2object;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

public class Json2ObjectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Json2ObjectRoute();
    }

    @Test
    public void json2objectTest() {

        String input = "{\"name\":\"Marco\",\"age\":\"25\"}";

        String expected = "Age: 25 Name: Marco";

        String employeeObject = template.requestBody("direct:json2objectInput", input, String.class);

        Assert.assertEquals(expected, employeeObject);
    }
}