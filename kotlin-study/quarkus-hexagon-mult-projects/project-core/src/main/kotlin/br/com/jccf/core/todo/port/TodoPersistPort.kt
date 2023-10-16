package br.com.jccf.core.todo.port

import br.com.jccf.core.todo.dto.TodoEntity

interface TodoPersistPort {
    fun insert(entity: TodoEntity)
}
