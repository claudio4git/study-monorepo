package br.com.jccf.springdepth.approach.property;

import br.com.jccf.springdepth.services.nonbean.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringPropertyApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new AnnotationConfigApplicationContext(PropertyApplicationConfig.class);
		OutputService outputService = context.getBean(OutputService.class);

		for (int i = 0; i < 5; i++) {
			outputService.generateOutput();
			Thread.sleep(1_000);
		}
	}
}
