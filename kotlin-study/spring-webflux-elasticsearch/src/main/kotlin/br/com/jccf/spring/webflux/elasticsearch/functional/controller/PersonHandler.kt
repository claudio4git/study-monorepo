package br.com.jccf.spring.webflux.elasticsearch.functional.controller

import br.com.jccf.spring.webflux.elasticsearch.model.People
import br.com.jccf.spring.webflux.elasticsearch.model.PeopleDocument
import br.com.jccf.spring.webflux.elasticsearch.repository.PersonElasticClientRepository
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import java.util.UUID

@Component
class PersonHandler(
    private val repository: PersonElasticClientRepository
) {

    suspend fun saveClient(request: ServerRequest): ServerResponse {
        val people = request.awaitBody<People>()
        return ServerResponse.ok().bodyValueAndAwait(repository.save(people).awaitSingle())
    }

    suspend fun saveTemplate(request: ServerRequest): ServerResponse {
        val people = request.awaitBody<PeopleDocument>()
        return ServerResponse.ok().bodyValueAndAwait(repository.save(people).awaitSingle())
    }

    suspend fun retrieve(request: ServerRequest): ServerResponse {
        val id = UUID.fromString(request.pathVariable("id"))
        return ServerResponse.ok().bodyValueAndAwait(repository.retrieve(id).awaitFirst())
    }
}