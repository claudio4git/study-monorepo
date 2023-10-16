package br.com.jccf.apachecamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ModifyDirectProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String oldValue = exchange.getIn().getBody().toString();
        String newValue = oldValue.replace(",", ":");
        exchange.getIn().setBody(newValue);
    }
}
