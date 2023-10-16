package br.com.jccf.springdepth.approach.scanning;

import br.com.jccf.springdepth.services.bean.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanningApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ScanningApplicationConfig.class);
		OutputService outputService = context.getBean(OutputService.class);

		for (int i = 0; i < 5; i++) {
			outputService.generateOutput();
			Thread.sleep(1_000);
		}
	}
}
