package br.com.jccf.springmvc.scylladb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMvcScyllaDbApplication

fun main(args: Array<String>) {
	runApplication<SpringMvcScyllaDbApplication>(*args)
}
