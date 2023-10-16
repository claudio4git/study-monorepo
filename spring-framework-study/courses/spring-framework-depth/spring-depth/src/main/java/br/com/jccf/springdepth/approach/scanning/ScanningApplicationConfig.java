package br.com.jccf.springdepth.approach.scanning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "br.com.jccf.springdepth.services.bean", "br.com.jccf.springdepth.aspect" })
public class ScanningApplicationConfig {

}
