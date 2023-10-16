package br.com.jccf.taskhub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMvcTaskhubApplication

fun main(args: Array<String>) {
	runApplication<SpringMvcTaskhubApplication>(*args)
}
