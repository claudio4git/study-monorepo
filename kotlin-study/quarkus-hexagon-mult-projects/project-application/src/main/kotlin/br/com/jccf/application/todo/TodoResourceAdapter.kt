package br.com.jccf.application.todo

import br.com.jccf.core.todo.dto.TodoRequest
import br.com.jccf.core.todo.dto.TodoResponse
import br.com.jccf.core.todo.port.TodoCreatePort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TodoResourceAdapter(
    private val todoCreate: TodoCreatePort
)  {

    fun create(request: TodoRequest): TodoResponse {
        return todoCreate.create(request)
    }
}
