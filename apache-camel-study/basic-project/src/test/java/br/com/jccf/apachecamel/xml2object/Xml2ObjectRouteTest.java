package br.com.jccf.apachecamel.xml2object;

import br.com.jccf.apachecamel.pojo.Person;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class Xml2ObjectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Xml2ObjectRoute();
    }

    @Test
    public void xmlToObjectTest() throws InterruptedException {
        Person person = new Person();
        person.setAge("26");
        person.setName("paul");

        String xmlInput = "<person><name>paul</name><age>26</age></person>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(person.toString());

        template.sendBody("direct:xmlToObjectInput", xmlInput);

        assertMockEndpointsSatisfied();
    }
}