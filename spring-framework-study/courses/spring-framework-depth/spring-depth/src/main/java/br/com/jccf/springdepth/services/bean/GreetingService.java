package br.com.jccf.springdepth.services.bean;

import br.com.jccf.springdepth.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${app.greeting}")
    private String greeting;

    public String getGreeting() {
        return greeting;
    }
}
