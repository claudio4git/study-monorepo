package br.com.jccf.springwebmvcrhpeoplemanagement.controller

import br.com.jccf.springwebmvcrhpeoplemanagement.dto.PeopleDto
import br.com.jccf.springwebmvcrhpeoplemanagement.service.PeopleService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/people")
class PeopleRestController(
    val service: PeopleService
) {

    @PostMapping
    fun create(@RequestBody people: PeopleDto): PeopleDto {
        return service.create(people)
    }

    @GetMapping
    fun list(): List<PeopleDto> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: UUID): PeopleDto {
        return service.getOne(id)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id: UUID) {
        service.deleteOne(id)
    }
}
