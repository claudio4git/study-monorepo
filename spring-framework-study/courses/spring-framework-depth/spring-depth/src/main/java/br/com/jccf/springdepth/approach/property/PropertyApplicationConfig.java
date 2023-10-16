package br.com.jccf.springdepth.approach.property;

import br.com.jccf.springdepth.services.nonbean.GreetingService;
import br.com.jccf.springdepth.services.nonbean.OutputService;
import br.com.jccf.springdepth.services.nonbean.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertyApplicationConfig {

    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    @Value("#{new Boolean(environment['spring.profiles.active']=='prop')}")
    private Boolean prop;

    @Autowired
    private TimeService timeService;

    @Autowired
    private GreetingService greetingService;

    @Bean
    @Profile("dev")
    public TimeService timeService() {
        return new TimeService(true);
    }

    @Bean
    public TimeService timeServiceProp() {
        return new TimeService(prop);
    }

    @Bean
    @Profile("prod")
    public TimeService timeService12() {
        return new TimeService(false);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greeting);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timeService, name);
    }
}
