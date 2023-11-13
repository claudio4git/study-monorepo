package br.com.jccf.springwebmvcrhpeoplemanagement.repository

import br.com.jccf.springwebmvcrhpeoplemanagement.entity.Address
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface AddressJpaRepository: CrudRepository<Address, UUID>
