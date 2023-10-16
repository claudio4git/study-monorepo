package br.com.jccf.application.task

import br.com.jccf.core.task.dto.TaskRequest
import br.com.jccf.core.task.dto.TaskResponse
import io.vertx.mutiny.core.eventbus.EventBus
import io.vertx.mutiny.core.eventbus.Message
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/v1/tasks")
class TaskResource(
    private val eventBus: EventBus
) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(request: TaskRequest): TaskResponse {
        return eventBus.request<TaskResponse>("createTask", request)
            .onItem()
            .apply(Message<TaskResponse>::body)
            .await()
            .indefinitely()
    }
}
