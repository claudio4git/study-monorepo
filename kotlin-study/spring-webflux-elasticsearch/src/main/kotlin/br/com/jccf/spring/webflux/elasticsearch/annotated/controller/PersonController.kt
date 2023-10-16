package br.com.jccf.spring.webflux.elasticsearch.annotated.controller

import br.com.jccf.spring.webflux.elasticsearch.model.PeopleDocument
import br.com.jccf.spring.webflux.elasticsearch.repository.PersonElasticSpringDataRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional
import java.util.UUID

@RestController
@RequestMapping("/api/v1/person")
class PersonController(
    private val repository: PersonElasticSpringDataRepository
) {

    @PostMapping
    fun save(@RequestBody people: PeopleDocument): PeopleDocument =
        repository.save(people)

    @GetMapping("/{id}")
    fun retrieve(@PathVariable id: UUID): Optional<PeopleDocument> =
        repository.findById(id.toString())

    @GetMapping
    fun list() : MutableIterable<PeopleDocument> =
        repository.findAll()
}