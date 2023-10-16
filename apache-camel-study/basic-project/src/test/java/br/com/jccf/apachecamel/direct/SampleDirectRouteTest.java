package br.com.jccf.apachecamel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRoute() throws InterruptedException {
        template.sendBody("direct:sampleInput", "123,345");

        Thread.sleep(5000);

        File file = new File("data/sampleOutput");

        Assert.assertTrue(file.isDirectory());

        Exchange exchange = consumer.receive("file:data/sampleOutput");
        Assert.assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}