package br.com.jccf.core.task.service

import br.com.jccf.core.task.dto.TaskEntity
import br.com.jccf.core.task.dto.TaskRequest
import br.com.jccf.core.task.dto.TaskResponse
import br.com.jccf.core.task.port.TaskCreatePort
import br.com.jccf.core.task.port.TaskPersistPort
import java.time.LocalDateTime
import java.util.UUID

class TaskService(
    private val taskPersist: TaskPersistPort
): TaskCreatePort {

    override fun create(request: TaskRequest): TaskResponse {
        val entity = TaskEntity(UUID.randomUUID(),
            request.name,
            LocalDateTime.now()
        )

        taskPersist.insert(entity)

        return TaskResponse(entity.id, entity.name, entity.createdAt)
    }
}
