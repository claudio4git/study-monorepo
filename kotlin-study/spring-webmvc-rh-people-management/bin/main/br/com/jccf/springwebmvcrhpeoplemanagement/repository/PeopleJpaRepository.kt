package br.com.jccf.springwebmvcrhpeoplemanagement.repository

import br.com.jccf.springwebmvcrhpeoplemanagement.entity.People
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PeopleJpaRepository: CrudRepository<People, UUID>
