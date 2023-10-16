package br.com.jccf.application.todo

import br.com.jccf.core.todo.port.TodoCreatePort
import br.com.jccf.core.todo.port.TodoPersistPort
import br.com.jccf.core.todo.service.TodoService
import br.com.jccf.infrastructure.todo.TodoPersistPostgreAdapter
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces
import javax.sql.DataSource

@Dependent
class TodoConfiguration(
    private val dataSource: DataSource
) {

    @Produces
    @DefaultBean
    fun getTodoCreatePort(): TodoCreatePort {
        return TodoService(getTodoPersistPort())
    }

    @Produces
    @DefaultBean
    fun getTodoPersistPort(): TodoPersistPort {
        return TodoPersistPostgreAdapter(dataSource)
    }
}
