package br.com.jccf.springdepth.services.nonbean;

public class OutputService {

    private final GreetingService greetingService;
    private final TimeService timeService;
    private String name = "";

    public OutputService(GreetingService greetingService, TimeService timeService) {
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    public OutputService(GreetingService greetingService, TimeService timeService, String name) {
        this.greetingService = greetingService;
        this.timeService = timeService;
        this.name = name;
    }

    public void generateOutput(String name) {
        System.out.printf("%s %s - %s%n", greetingService.getGreeting(), name, timeService.getTime());
    }

    public void generateOutput() {
        System.out.printf("%s %s - %s%n", greetingService.getGreeting(), name, timeService.getTime());
    }
}
