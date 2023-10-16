package br.com.jccf.spring.webflux.elasticsearch.annotated.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/annotated/hello")
    fun hello() : ResponseEntity<String> =
        ResponseEntity.ok("Hello world with annotation")
}