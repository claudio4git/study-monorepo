package br.com.jccf.application.todo

import br.com.jccf.core.todo.dto.TodoRequest
import br.com.jccf.core.todo.dto.TodoResponse
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/v1/todos")
class TodoResource(
    private val todoResourceAdapter: TodoResourceAdapter
) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(request: TodoRequest): TodoResponse {
        return todoResourceAdapter.create(request)
    }
}
