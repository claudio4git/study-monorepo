package br.com.jccf.springwebmvcrhpeoplemanagement.repository

import br.com.jccf.springwebmvcrhpeoplemanagement.entity.Document
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface DocumentJpaRepository: CrudRepository<Document, UUID>
