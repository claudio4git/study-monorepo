package br.com.jccf.springwebmvcrhpeoplemanagement.converter

import br.com.jccf.springwebmvcrhpeoplemanagement.dto.AddressDto
import br.com.jccf.springwebmvcrhpeoplemanagement.entity.Address
import br.com.jccf.springwebmvcrhpeoplemanagement.entity.People
import java.util.*

fun Address.toDto() =
    AddressDto(this.id, this.type, this.name)

fun AddressDto.toEntity(people: People): Address {
    val entity = Address()
    entity.id = this.id ?: UUID.randomUUID()
    entity.people = people
    entity.type = this.type
    entity.name = this.name

    return entity
}
