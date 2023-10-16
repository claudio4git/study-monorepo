package br.com.jccf.taskhub.model

import br.com.jccf.taskhub.common.StatusType
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity(name = "task_hub")
class TaskHubEntity(
        @Id
        val id: UUID? = UUID.randomUUID(),
        val title: String,
        val description: String,
        @Enumerated(EnumType.STRING)
        val status: StatusType,
        @Column(name = "creation_date")
        val creationDate: LocalDateTime? = LocalDateTime.now()
)
