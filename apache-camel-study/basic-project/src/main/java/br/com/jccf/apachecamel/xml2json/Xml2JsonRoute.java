package br.com.jccf.apachecamel.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class Xml2JsonRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:xml2jsonMarshalInput")
                .log("log:level=INFO&showBody=true")
                .marshal().xmljson()
                .log("log:level=INFO&showBody=true");

        XmlJsonDataFormat dataFormat = new XmlJsonDataFormat();
        dataFormat.setRootName("person");

        from("direct:xml2jsonUnmarshalInput")
                .log("log:level=INFO&showBody=true")
//                .unmarshal().xmljson()
                .unmarshal(dataFormat)
                .log("log:level=INFO&showBody=true");
    }
}
