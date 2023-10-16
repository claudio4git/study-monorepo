package br.com.jccf.springwebmvcrhpeoplemanagement.converter

import br.com.jccf.springwebmvcrhpeoplemanagement.dto.PeopleDto
import br.com.jccf.springwebmvcrhpeoplemanagement.entity.People
import java.util.*

fun People.toDto() =
    PeopleDto(this.id, this.name, this.address?.toDto())

fun PeopleDto.toEntity(): People {
    val entity = People()
    entity.id = this.id ?: UUID.randomUUID()
    entity.address = this.address?.toEntity(entity)
    entity.name = this.name

    return entity
}
