package br.com.jccf.project.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectApiApplication

fun main(args: Array<String>) {
	runApplication<ProjectApiApplication>(*args)
}
