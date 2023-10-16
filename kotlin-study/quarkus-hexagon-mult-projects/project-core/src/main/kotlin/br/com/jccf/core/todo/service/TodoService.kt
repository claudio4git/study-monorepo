package br.com.jccf.core.todo.service

import br.com.jccf.core.todo.dto.TodoEntity
import br.com.jccf.core.todo.dto.TodoRequest
import br.com.jccf.core.todo.dto.TodoResponse
import br.com.jccf.core.todo.port.TodoCreatePort
import br.com.jccf.core.todo.port.TodoPersistPort
import java.time.LocalDateTime
import java.util.UUID

class TodoService(
    private val todoPersist: TodoPersistPort
) : TodoCreatePort {

    override fun create(request: TodoRequest): TodoResponse {
        val entity = TodoEntity(UUID.randomUUID(),
            request.name,
            LocalDateTime.now()
        )

        todoPersist.insert(entity)

        return TodoResponse(entity.id, entity.name, entity.createdAt)
    }
}
