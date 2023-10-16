package br.com.jccf.springwebmvcrhpeoplemanagement.service

import br.com.jccf.springwebmvcrhpeoplemanagement.converter.toDto
import br.com.jccf.springwebmvcrhpeoplemanagement.converter.toEntity
import br.com.jccf.springwebmvcrhpeoplemanagement.dto.PeopleDto
import br.com.jccf.springwebmvcrhpeoplemanagement.repository.PeopleJpaRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PeopleService(
    val repository: PeopleJpaRepository
) {

    fun create(people: PeopleDto): PeopleDto {
        return repository.save(people.toEntity()).toDto()
    }

    fun list(): List<PeopleDto> {
        return repository.findAll()
            .map { it.toDto() }
    }

    fun getOne(id: UUID): PeopleDto {
        return repository.findById(id)
            .map { it.toDto() }
            .orElseThrow()
    }

    fun deleteOne(id: UUID) {
        repository.deleteById(id)
    }
}
