package br.com.jccf.core.todo.port

import br.com.jccf.core.todo.dto.TodoRequest
import br.com.jccf.core.todo.dto.TodoResponse

interface TodoCreatePort {
    fun create(request: TodoRequest): TodoResponse
}
