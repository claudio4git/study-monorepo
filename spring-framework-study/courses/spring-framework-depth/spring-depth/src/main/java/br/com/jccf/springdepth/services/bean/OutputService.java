package br.com.jccf.springdepth.services.bean;

import br.com.jccf.springdepth.aspect.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputService {

    @Value("${app.name}")
    private String name;

    private final GreetingService greetingService;
    private final TimeService timeService;

    @Autowired
    public OutputService(GreetingService greetingService, TimeService timeService) {
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    @Loggable
    public void generateOutput() {
        System.out.printf("%s %s - %s%n", greetingService.getGreeting(), name, timeService.getTime());
    }
}
