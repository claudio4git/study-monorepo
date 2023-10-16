package br.com.jccf.application.task

import br.com.jccf.core.task.port.TaskCreatePort
import br.com.jccf.core.task.port.TaskPersistPort
import br.com.jccf.core.task.service.TaskService
import br.com.jccf.infrastructure.task.TaskPersistPostgreAdapter
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces
import javax.sql.DataSource

@Dependent
class TaskConfiguration(
    private val dataSource: DataSource
) {

    @Produces
    @DefaultBean
    fun getTaskCreatePort(): TaskCreatePort {
        return TaskService(getTaskPersistPort())
    }

    @Produces
    @DefaultBean
    fun getTaskPersistPort(): TaskPersistPort {
        return TaskPersistPostgreAdapter(dataSource)
    }
}
