package br.com.jccf.springwebmvcrhpeoplemanagement.repository

import br.com.jccf.springwebmvcrhpeoplemanagement.entity.Skill
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface SkillJpaRepository: CrudRepository<Skill, UUID>
