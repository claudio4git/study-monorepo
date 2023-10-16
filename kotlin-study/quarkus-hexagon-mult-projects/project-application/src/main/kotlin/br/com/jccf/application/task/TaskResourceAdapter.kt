package br.com.jccf.application.task

import br.com.jccf.core.task.dto.TaskRequest
import br.com.jccf.core.task.dto.TaskResponse
import br.com.jccf.core.task.port.TaskCreatePort
import io.quarkus.vertx.ConsumeEvent
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TaskResourceAdapter(
    private val taskCreate: TaskCreatePort
) {

    @ConsumeEvent("createTask")
    fun create(request: TaskRequest): TaskResponse {
        return taskCreate.create(request)
    }
}
