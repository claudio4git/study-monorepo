package br.com.jccf.apachecamel.xml2object;

import br.com.jccf.apachecamel.pojo.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class Xml2ObjectRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        Map<String, String> aliases = new HashMap<>();
        aliases.put("person", Person.class.getName());

        XStreamDataFormat dataFormat = new XStreamDataFormat();
        dataFormat.setAliases(aliases);
        dataFormat.setPermissions(Person.class.getName());

        from("direct:xmlToObjectInput")
                .unmarshal(dataFormat)
                .to("log:level=INFO&showBody=true")
                .to("mock:output");
    }
}
