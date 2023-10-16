package br.com.jccf.springwebmvcrhpeoplemanagement.dto

import br.com.jccf.springwebmvcrhpeoplemanagement.entity.AddressType
import java.util.UUID

data class AddressDto(
    val id: UUID?,
    val type: AddressType?,
    val name: String?
)
