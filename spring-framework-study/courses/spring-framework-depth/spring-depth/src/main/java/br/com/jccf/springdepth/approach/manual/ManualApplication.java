package br.com.jccf.springdepth.approach.manual;

import br.com.jccf.springdepth.services.nonbean.GreetingService;
import br.com.jccf.springdepth.services.nonbean.OutputService;
import br.com.jccf.springdepth.services.nonbean.TimeService;

public class ManualApplication {

	public static void main(String[] args) throws InterruptedException {
		GreetingService greetingService = new GreetingService("Hello");
		TimeService timeService = new TimeService(true);
		OutputService outputService = new OutputService(greetingService, timeService);

		for (int i = 0; i < 5; i++) {
			outputService.generateOutput("Claudio manual");
			Thread.sleep(1_000);
		}
	}
}
