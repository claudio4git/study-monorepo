package br.com.jccf.apachecamel.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

public class Xml2JsonRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Xml2JsonRoute();
    }

    @Test
    public void marshalTest() {

        String input = "<?xml version='1.0' encoding='UTF-8'?><person><name>paul</name><age>26</age></person>";
        String expected = "{\"name\":\"paul\",\"age\":\"26\"}";

        String output = template.requestBody("direct:xml2jsonMarshalInput", input, String.class);

        Assert.assertEquals(output, expected);
    }

    @Test
    public void unmarshalTest() {

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<person><age>26</age><name>paul</name></person>\r\n";
        String input = "{\"name\":\"paul\",\"age\":\"26\"}";

        String output = template.requestBody("direct:xml2jsonUnmarshalInput", input, String.class);

        Assert.assertEquals(output, expected);
    }
}