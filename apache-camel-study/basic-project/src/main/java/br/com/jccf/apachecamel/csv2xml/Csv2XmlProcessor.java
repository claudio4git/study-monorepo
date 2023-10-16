package br.com.jccf.apachecamel.csv2xml;

import br.com.jccf.apachecamel.pojo.Person;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.StringTokenizer;

public class Csv2XmlProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String value = exchange.getIn().getBody(String.class);
        StringTokenizer tokenizer = new StringTokenizer(value, ",");

        Person person = new Person();
        while (tokenizer.hasMoreElements()) {
            person.setName(tokenizer.nextElement().toString());
            person.setAge(tokenizer.nextElement().toString());
        }

        exchange.getIn().setBody(person);
    }
}
