package br.com.jccf.apachecamel.json2object;

import br.com.jccf.apachecamel.pojo.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class Json2ObjectRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        GsonDataFormat dataFormat = new GsonDataFormat(Person.class);

        from("direct:json2objectInput")
                .log("Body is ${body}")
                .unmarshal(dataFormat)
                .log("Body is ${body}");
    }
}
