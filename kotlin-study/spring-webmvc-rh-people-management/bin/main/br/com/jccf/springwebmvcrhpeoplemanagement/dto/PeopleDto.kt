package br.com.jccf.springwebmvcrhpeoplemanagement.dto

import java.util.UUID

data class PeopleDto(
    val id: UUID?,
    val name: String?,
    val address: AddressDto?
)
