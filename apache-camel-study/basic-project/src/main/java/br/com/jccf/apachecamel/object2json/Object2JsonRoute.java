package br.com.jccf.apachecamel.object2json;

import br.com.jccf.apachecamel.pojo.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class Object2JsonRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        GsonDataFormat dataFormat = new GsonDataFormat(Person.class);

        from("direct:object2jsonInput")
                .log("Body is ${body}")
                .marshal(dataFormat)
                .log("Body is ${body}");
    }
}
