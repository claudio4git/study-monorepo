package br.com.jccf.springdepth.approach.springcontext;

import br.com.jccf.springdepth.services.nonbean.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextApplicationConfig.class);
		OutputService outputService = context.getBean(OutputService.class);

		for (int i = 0; i < 5; i++) {
			outputService.generateOutput("Claudio spring context");
			Thread.sleep(1_000);
		}
	}
}
