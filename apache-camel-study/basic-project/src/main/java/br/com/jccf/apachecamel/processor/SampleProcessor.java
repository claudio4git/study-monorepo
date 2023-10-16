package br.com.jccf.apachecamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class SampleProcessor implements Processor {

    private static final Logger LOGGER = Logger.getLogger(SampleProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info("This is a process");
    }
}
