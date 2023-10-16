package br.com.jccf.spring.webflux.elasticsearch.functional.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class HelloWorldRouter {

    @Bean
    fun hello(handler: HelloWorldHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/functional/hello", handler::hello)
        }
    }
}