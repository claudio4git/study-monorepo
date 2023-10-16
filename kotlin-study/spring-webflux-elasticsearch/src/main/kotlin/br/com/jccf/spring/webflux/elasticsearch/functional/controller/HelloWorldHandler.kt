package br.com.jccf.spring.webflux.elasticsearch.functional.controller

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class HelloWorldHandler {

    suspend fun hello(request: ServerRequest) =
        ServerResponse.ok().bodyValueAndAwait("Hello world with functional")
}