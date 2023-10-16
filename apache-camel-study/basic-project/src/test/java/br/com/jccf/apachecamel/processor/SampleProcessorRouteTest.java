package br.com.jccf.apachecamel.processor;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class SampleProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleProcessorRoute();
    }

    @Test
    public void processTest() throws InterruptedException {
        Thread.sleep(5000);

        File file = new File("data/output");

        Assert.assertTrue(file.isDirectory());
    }
}