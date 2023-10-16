package br.com.jccf.apachecamel.errorhandler;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class ErrorHandlerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

//        errorHandler(defaultErrorHandler());

//        errorHandler(defaultErrorHandler()
//                .maximumRedeliveries(2)
//                .redeliveryDelay(3000)
//                .retryAttemptedLogLevel(LoggingLevel.WARN));

//        errorHandler(defaultErrorHandler()
//                .maximumRedeliveries(2)
//                .redeliveryDelay(3000)
//                .backOffMultiplier(2)
//                .retryAttemptedLogLevel(LoggingLevel.WARN));

//        onException(RuntimeException.class).log(LoggingLevel.WARN, "Error on route");

//        onException(RuntimeException.class).log(LoggingLevel.WARN, "Error on route").process(new SomeoneClass());

        onException(RuntimeException.class).continued(true).log(LoggingLevel.WARN, "Error on route");

        from("direct:exception")
                .bean(new ErrorHandlerMap())
                .to("log:level=INFO&shoBody=true")
                .to("mock:errorOutput");
    }
}
