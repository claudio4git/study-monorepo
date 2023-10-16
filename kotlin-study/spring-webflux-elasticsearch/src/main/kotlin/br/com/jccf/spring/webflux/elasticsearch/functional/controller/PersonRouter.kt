package br.com.jccf.spring.webflux.elasticsearch.functional.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class PersonRouter {

    @Bean
    fun personRouterV2(handler: PersonHandler) = coRouter {
        "/api/v2/person".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                POST("/client", handler::saveClient)
                POST("/template", handler::saveTemplate)
                GET("/{id}", handler::retrieve)
            }
        }
    }
}