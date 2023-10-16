package br.com.jccf.taskhub.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskHubRepository : JpaRepository<TaskHubEntity, UUID>