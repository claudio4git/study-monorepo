package br.com.jccf.apachecamel.csv2xml;

import br.com.jccf.apachecamel.pojo.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class Csv2XmlRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:marshalInput")
                .log("Body message is ${body}")
                .process(new Csv2XmlProcessor())
//                .csv2xml().xstream()
                .marshal(populateXStreamDef())
                .to("log:?level=INFO&showBody=True")
                .to("mock:output");
    }

    private XStreamDataFormat populateXStreamDef() {
        XStreamDataFormat dataFormat = new XStreamDataFormat();

        Map<String, String> aliases = new HashMap<>();
        aliases.put("person", Person.class.getName());

        dataFormat.setAliases(aliases);

        return dataFormat;
    }

}
