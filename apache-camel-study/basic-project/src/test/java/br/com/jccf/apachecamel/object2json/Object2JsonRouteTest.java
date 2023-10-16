package br.com.jccf.apachecamel.object2json;

import br.com.jccf.apachecamel.pojo.Person;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

public class Object2JsonRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Object2JsonRoute();
    }

    @Test
    public void object2jsonTest() {

        Person person = new Person();
        person.setAge("25");
        person.setName("Marco");

        String expected = "{\"name\":\"Marco\",\"age\":\"25\"}";

        String employeeJson = template.requestBody("direct:object2jsonInput", person, String.class);

        Assert.assertEquals(expected, employeeJson);
    }
}