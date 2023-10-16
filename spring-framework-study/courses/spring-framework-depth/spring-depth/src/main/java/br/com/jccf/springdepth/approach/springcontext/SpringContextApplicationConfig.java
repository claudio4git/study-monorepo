package br.com.jccf.springdepth.approach.springcontext;

import br.com.jccf.springdepth.services.nonbean.GreetingService;
import br.com.jccf.springdepth.services.nonbean.OutputService;
import br.com.jccf.springdepth.services.nonbean.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextApplicationConfig {

    @Value("Hello")
    private String greeting;

    @Autowired
    private TimeService timeService;

    @Autowired
    private GreetingService greetingService;

    @Bean
    public TimeService timeService() {
        return new TimeService(true);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService("Hello");
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timeService);
    }
}
